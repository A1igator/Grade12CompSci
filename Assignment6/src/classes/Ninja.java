package classes;

/**
 * Ninja.java
 * Name: Ali Abdoli
 * Date: May 13, 2019
 *
 *     Purpose: Java program to implement a Ninja class.
 * Methods:
 *  losesStrength - no return
 *  gainsStrength - no return
 */

public class Ninja extends Warrior {
    public Ninja(String name, int strength, int points) {
        super(name, strength, points);
    }

    public void losesStrength(int pts) {
        strength -= pts * 0.7;
    }

    public void gainsStrength(int pts) {
        strength += pts * 0.7;
    }
}
