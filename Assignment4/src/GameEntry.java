/**
 * GameEntry.java
 * Name: Ali Abdoli
 * Date: April 13, 2019
 *
 *     Purpose: Java program for a class to create a minesweeper game entry.
 *
 * Methods:
 *     GameEntry(String username, int time, String level) - overloading constructor - no return
 *     getUsername - returns String
 *     getTime - returns int
 *     getLevel - returns level
 *     setUsername - no return
 *     setTime - no return
 *     setLevel - no return
 *     equals - returns boolean
 *     toString - returns String
 */

public class GameEntry {
    private String username, level;
    private int time;

    GameEntry() {
        username = "Unknown";
        time = 0;
        level = "Unknown";
    }

    GameEntry(String username, int time, String level) {
        this.username = username;
        this.time = time;
        this.level = level;
    }

    public String getUsername() {
        return username;
    }

    public int getTime() {
        return time;
    }

    public String getLevel() {
        return level;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void seTime(int time) {
        this.time = time;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public boolean equals(Object entryObj) {
        if (entryObj == null) {
            return false;
        }

        // Make sure the two objects are of the same class.
        if (this.getClass() != entryObj.getClass())
            return false;

        // Now type−cast the incoming object to a GameEntry object.
        GameEntry entry = (GameEntry) entryObj;

        // Now check for equality.
        return this.getUsername().equals(entry.getUsername()) && this.getLevel().equals(entry.getLevel());
    }

    // return a string representation of the entry.
    public String toString() {
        return username + ", " + time + ", " + level;
    }
}
