package classes;

//TestGame.java - main method to test the Avatar hierarchy
//
//Tunde Forrest, 29 Apr 2019


public class TestGame {

    public static void main(String[] args) {
        //Create the players
        Player george = new Player();
        Player holly = new Player();
        Player fred = new Player();

        //show their avatars
        System.out.println("George's character");
        System.out.println(george);
        System.out.println("Holly's character");
        System.out.println(holly);
        System.out.println("Fred's character");
        System.out.println(fred);

        //george defeated in round one losing life and 200 pts
        george.loseLife();
        george.losePoints(200);

        //holly wins round one gaining 500 pts.
        holly.gainsPoints(500);

        // fred wins life and loses 50 pts.
        fred.gainLife();
        fred.losePoints(50);

        //show their avatars
        System.out.println("George's character");
        System.out.println(george);
        System.out.println("Holly's character");
        System.out.println(holly);
        System.out.println("Fred's character");
        System.out.println(fred);

        //compare points and strength
        System.out.println("George has " + george.getCharacter().getName() + " with strength of " + george.getCharacter().getStrength() + " and " + george.getCharacter().getPoints() + " points");
        System.out.println("Holly has " + holly.getCharacter().getName() + " with strength of " + holly.getCharacter().getStrength() + " and " + holly.getCharacter().getPoints() + " points");
        System.out.println("Fred has " + fred.getCharacter().getName() + " with strength of " + fred.getCharacter().getStrength() + " and " + fred.getCharacter().getPoints() + " points");
    }

}
