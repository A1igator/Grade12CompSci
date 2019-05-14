package classes;

/**
 * Weapon.java
 * Name: Ali Abdoli
 * Date: May 13, 2019
 *
 *     Purpose: Java program to implement a Weapon class.
 * Methods:
 *  getName - returns String
 *  getDurability - returns int
 *  getRange - returns int
 *  toString - returns String
 */

public abstract class Weapon {
    protected String name;
    private int durability;
    private int damage;
    private int range;

    Weapon() {
        name = "";
        durability = 0;
        damage = 0;
        range = 0;
    }

    Weapon(String name, int durability, int damage, int range) {
        this.name = name;
        this.durability = durability;
        this.damage = damage;
        this.range = range;
    }

    public String getName() {
        return name;
    }

    public int getDurability() {
        return durability;
    }

    public int getDamage() {
        return damage;
    }

    public int getRange() {
        return range;
    }

    public String toString() {
        return name + " durability of: " + durability + ", " + damage + " damage and " + range + " range";
    }
}