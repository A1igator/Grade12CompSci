package classes;

/**
 * Gun.java
 * Name: Ali Abdoli
 * Date: May 13, 2019
 *
 *     Purpose: Java program to implement a Gun class.
 */

public class Gun extends Range {
    Gun() {
        super();
    }

    Gun(String name, int durability, int damage, int range) {
        super(name, durability, damage, range);
    }
}
