package classes;

/**
 * Knight.java
 * Name: Ali Abdoli
 * Date: May 13, 2019
 *
 *     Purpose: Java program to implement a Knight class.
 * Methods:
 *  losesStrength - no return
 *  gainsStrength - no return
 */

public class Knight extends Warrior {
    public Knight(String name, int strength, int points) {
        super(name, strength, points);
    }

    public void losesStrength(int pts) {
        strength -= pts/4;
    }

    public void gainsStrength(int pts) {
        strength += pts/4;
    }
}
