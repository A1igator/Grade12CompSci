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
        // First make sure the two objects are of the same class
        if (this.getClass() != entryObj.getClass())
            return false;

        // Now type−cast the incoming object to a GameEntry object
        GameEntry entry = (GameEntry) entryObj;

        // Now check for equality
        return this.getUsername().equals(entry.getUsername()) &&
                this.getLevel().equals(entry.getLevel());
    }


    public String toString() {
        return username + ", " + time + ", " + level;
    }
}
