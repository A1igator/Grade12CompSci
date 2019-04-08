import java.util.ArrayList;
import java.util.Iterator;

public class DisplayScore {
    private ArrayList<GameEntry> entries;

    DisplayScore() {
        entries = new ArrayList<>();
    }

    public void add(String username, int time, String level) {
        GameEntry entry = new GameEntry(username,time,level);
        entries.add(entry);
        for (int i = 1; i < entries.size(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (entries.get(j).getTime() > entries.get(j + 1).getTime())
                    swap(j + 1, j);
                else
                    break;
            }
        }
        if (entries.size() > 10)
            entries.remove(entries.size() - 1);
    }

    public void remove(String username, String level) {
        Iterator itr = entries.iterator();
        while (itr.hasNext()) {
            GameEntry entry = (GameEntry)itr.next();
            if (entry.equals(new GameEntry(username,0,level))) {
                itr.remove();
                break;
            }
        }
//         for (GameEntry entry: entries){
//             if (entry.equals(new GameEntry(username,0,level))) {
//                 entries.remove(entry);
//                 break;
//             }
//         }
    }

    public void sortName() {
        boolean swapped;
        for (int j = 0; j < entries.size() - 1; j++) {
            swapped = false;
            for (int i = 0; i < entries.size() - j - 1; i++) {
                if (entries.get(i).getUsername().compareTo(entries.get(i + 1).getUsername()) > 0) {
                    swap(i, i + 1);
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }

    public void sortTime() {
        for (int j = 0; j < entries.size(); j++) {
            int smallest = Integer.MAX_VALUE;
            int smallestIndex = -1;
            for (int i = j; i < entries.size(); i++) {
                if (entries.get(i).getTime() < smallest) {
                    smallest = entries.get(i).getTime();
                    smallestIndex = i;
                }
            }
            swap(j, smallestIndex);
        }
    }

    public String toString(){
        // return a string representation of 5 entries in the entries[] array
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < entries.size(); i++){
            if (i > 0)
                s.append('\n');
            s.append(entries.get(i));
        }
        return s.toString();
    }

    private void swap (int i, int j) {
        GameEntry t = entries.get(i);
        entries.set(i, entries.get(j));
        entries.set(j, t);
    }
}
