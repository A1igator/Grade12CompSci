package classes;

/**
 * Bow.java
 * Name: Ali Abdoli
 * Date: May 13, 2019
 *
 *     Purpose: Java program to implement a Bow class.
 */

public class Bow extends Range {
    Bow() {
        super();
    }

    Bow(String name, int durability, int damage, int range) {
        super(name, durability, damage, range);
    }
}
