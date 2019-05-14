package classes;

/**
 * Wizard.java
 * Name: Ali Abdoli
 * Date: May 13, 2019
 *
 *     Purpose: Java program to implement a Wizard class.
 * Methods:
 *  getStrength - returns int
 *  getPoints - returns int
 *  losesStrength - no return
 *  gainsStrength - no return
 *  toString - returns String
 */

public class Wizard extends Avatar {
    public int points;
    public int strength;

    public Wizard() {
        super();
        this.points = 0;
        this.strength = 0;
    }

    public Wizard(String name, int strength, int points) {
        super(name);
        this.points = points;
        this.strength = strength;
    }


    public int getStrength() {
        return strength;
    }

    public int getPoints() {
        return points;
    }

    public void losesStrength(int pts) {
        strength -= pts/2;
    }

    public void gainsStrength(int pts) {
        strength += pts/2;
    }

    public String toString() {
        return name + " strength of: " + strength + " and " + points + " points\n";
    }
}

