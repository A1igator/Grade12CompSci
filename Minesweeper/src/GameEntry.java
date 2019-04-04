public class GameEntry {
    String username;
    int time;
    String level;

    GameEntry() {
        username = "Unknown";
        time = 0;
        level = "Uknown";
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

    public String toString() {
        return username + "," + time + "," + level;
    }
}
