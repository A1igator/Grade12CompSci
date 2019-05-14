package classes;

/**
 * Range.java
 * Name: Ali Abdoli
 * Date: May 13, 2019
 *
 *     Purpose: Java program to implement a Range class.
 */

public abstract class Range extends Weapon {

    Range() {
        super();
    }

    Range(String name, int durability, int damage, int range) {
        super(name, durability, damage, range);
    }
}
