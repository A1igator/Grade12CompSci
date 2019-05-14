package classes;

/**
 * Warrior.java
 * Name: Ali Abdoli
 * Date: May 13, 2019
 *
 *     Purpose: Java program to implement a Warrior class.
 * Methods:
 *  getStrength - returns int
 *  getPoints - returns int
 *  losesStrength - no return
 *  gainsStrength - no return
 *  toString - returns String
 */

public class Warrior extends Avatar {
    protected int points;
    protected int strength;

    public Warrior() {
        super();
        this.points = 0;
        this.strength = 0;
    }

    public Warrior(String name, int strength, int points) {
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
