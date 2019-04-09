import java.util.ArrayList;
import java.util.ListIterator;

public class DisplayScore {
    private ArrayList<GameEntry>[] allLevelEntries;

    DisplayScore() {
        allLevelEntries = (ArrayList<GameEntry>[])new ArrayList[3];
        for (int i = 0; i < 3; i++)
            allLevelEntries[i] = new ArrayList<>();
    }

    public void add(String username, int time, String level) {
        GameEntry entry = new GameEntry(username, time, level);

        int index = -1;
        if (entry.getLevel().equals("Expert"))
            index = 0;
        else if (entry.getLevel().equals("Intermediate"))
            index = 1;
        else if (entry.getLevel().equals("Beginner"))
            index = 2;
        System.out.println(entry.getLevel());
        for (int j = allLevelEntries[index].size() - 1; j >= 0; j--) {
            if (allLevelEntries[index].get(j).getTime() < entry.getTime()) {
                System.out.println("test" + index);
                allLevelEntries[index].add(j + 1, entry);
                break;
            }
        }
        if (allLevelEntries[index].size() != 0) {
            if (!allLevelEntries[index].contains(entry))
                allLevelEntries[index].add(allLevelEntries[index].size() - 1, entry);
        } else
            allLevelEntries[index].add(0, entry);

        if (allLevelEntries[index].size() > 10)
             allLevelEntries[index].remove(allLevelEntries[index].size() - 1);
    }

    public void remove(String username, String level) {
        for (ArrayList<GameEntry> entries: allLevelEntries) {
            ListIterator itr = entries.listIterator(entries.size());
            while (itr.hasPrevious()) {
                GameEntry entry = (GameEntry)itr.previous();
                System.out.println(entry);
                if (entry.equals(new GameEntry(username, 0, level))) {
                    itr.remove();
                    break;
                }
            }
        }
    }

    public void sortName() {
        boolean swapped;
        for (ArrayList<GameEntry> entries: allLevelEntries) {
            for (int j = 0; j < entries.size() - 1; j++) {
                swapped = false;
                for (int i = 0; i < entries.size() - j - 1; i++) {
                    if (entries.get(i).getUsername().compareTo(entries.get(i + 1).getUsername()) > 0) {
                        swap(entries, i, i + 1);
                        swapped = true;
                    }
                }
                if (!swapped)
                    break;
            }
        }
    }

    public void sortTime() {
        for (ArrayList<GameEntry> entries: allLevelEntries) {
            for (int j = 0; j < entries.size(); j++) {
                int smallest = Integer.MAX_VALUE;
                int smallestIndex = -1;
                for (int i = j; i < entries.size(); i++) {
                    if (entries.get(i).getTime() < smallest) {
                        smallest = entries.get(i).getTime();
                        smallestIndex = i;
                    }
                }
                swap(entries, j, smallestIndex);
            }
        }
    }

    public String toString(){
        // return a string representation of 5 entries in the entries[] array
        StringBuilder s = new StringBuilder();
        for (ArrayList<GameEntry> entries: allLevelEntries) {
            for (int i = 0; i < entries.size(); i++) {
                if (i > 0)
                    s.append('\n');
                s.append(entries.get(i));
            }
            if (entries.size() > 0)
                s.append('\n');
        }
        return s.toString();
    }

    private void swap (ArrayList<GameEntry> entries, int i, int j) {
        GameEntry t = entries.get(i);
        entries.set(i, entries.get(j));
        entries.set(j, t);
    }
}
