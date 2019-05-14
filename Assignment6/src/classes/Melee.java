package classes;

/**
 * Melee.java
 * Name: Ali Abdoli
 * Date: May 13, 2019
 *
 *     Purpose: Java program to implement a Melee weapon class.
 */

public abstract class Melee extends Weapon {

    Melee() {
        super();
    }

    Melee(String name, int durability, int damage) {
        super(name, durability, damage, 0);
    }
}
