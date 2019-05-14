package classes;
import java.util.*;

/**
 * Player.java - class to determine which avatar to choose.
 * @author Tunde Forrest
 * modified by: Ali Abdoli
 * 
 * Methods:
 *  chooseAvatar - no return
 *  chooseWeapon - returns Weapon
 *  looseLife - no return
 *  gainLife - no return
 *  gainsPoints - no return
 *  losePoints - no return
 *  getCharacter - returns Avatar
 *  toString - returns String
 */

public class Player {
    private int lives;
    private Avatar character;
    private Weapon wpn;

    Player() {
        lives = 3;
        chooseAvatar();
        wpn = chooseWeapon();
    }

    public void chooseAvatar() {
        System.out.println("Please choose one of the following: Wizard or Warrior");
        Scanner in = new Scanner(System.in);
        String choice= in.nextLine();

        if(choice.equals("Wizard")) {
            System.out.println("Please enter the Wizards name:");
            String name = in.nextLine();
            character = new Wizard(name, 500, 500);
        } else {
            System.out.println("Please enter one of the following: Ninja or Knight");
            String option = in.nextLine();
            if (option.equals("Ninja"))
                character = new Ninja("Black Viper", 400, 600);
            else
                character = new Knight("Sir Slash", 600, 400);

        }
        wpn = new Wand("Wandy", 20,100,5);
    }

    public Weapon chooseWeapon() {
        System.out.println("Please choose one of the following: Melee or Range");
        Scanner in = new Scanner(System.in);
        String choice= in.nextLine();
        System.out.println("Please enter the Weapon's name:");
        String name = in.nextLine();

        if (choice.equals("Melee")) {
            System.out.println("Please enter one of the following: Baseball Bat, Boxing Glove, Brass Knuckles, or Sword");
            String option = in.nextLine();
            switch (option) {
                case "BaseBall Bat":
                    return new BaseballBat(name, 8, 1000);
                case "Boxing Glove":
                    return new BoxingGlove(name, 20, 100);
                case "Brass Knuckles":
                    return new BrassKnuckles(name, 10, 300);
                case "Sword":
                    return new Sword(name, 4, 2000);
            }

        } else if (choice.equals("Range")) {
            System.out.println("Please enter one of the following: Wand, Gun, or Bow");
            String option = in.nextLine();
            switch (option) {
                case "Wand":
                    return new Wand(name, 20, 100, 5);
                case "Gun":
                    return new Gun(name, 10, 100, 20);
                case "Bow":
                    return new Bow(name, 50, 50, 10);
            }
        }
        return null;
    }


    public void loseLife() {
        lives-=1;
    }

    public void gainLife() {
        lives +=1;
    }

    public void gainsPoints(int pts) {
        character.gainsStrength(pts);
    }

    public void losePoints(int pts) {
        character.losesStrength(pts);
    }

    public Avatar getCharacter() {
        return character;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("The character is ");
        str.append(character);
        str.append("Number of lives is: ");
        str.append(lives);
        str.append('\n');
        str.append("The weapon is ");
        str.append(wpn);
        return str.toString();

    }
}

