package classes;

/**
 * Wand.java
 * Name: Ali Abdoli
 * Date: May 13, 2019
 *
 *     Purpose: Java program to implement a Wand class.
 */

public class Wand extends Range {
    Wand() {
        super();
    }

    Wand(String name, int durability, int damage, int range) {
        super(name, durability, damage, range);
    }
}
