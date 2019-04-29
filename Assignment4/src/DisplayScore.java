/**
 * DisplayScore.java
 * Name: Ali Abdoli
 * Date: April 13, 2019
 *
 *     Purpose: Java program for storing, and creating instances of GameEntry in the entries ArrayList, and performing operations on the ArrayList.
 *
 * Methods:
 *     add - no return
 *     remove - no return
 *     sortName - no return
 *     sortTime - no return
 *     toString - returns String
 *     swap - no return
 */

import java.util.ArrayList;
import java.util.ListIterator;

public class DisplayScore {
    private ArrayList<GameEntry> entries;
    private boolean isTimeSort;

    DisplayScore() {
        entries = new ArrayList<>();
        for (int i = 0; i < 30; i++)
            entries.add(null);
    }

    public void add(String username, int time, String level) {
        GameEntry entry = new GameEntry(username, time, level);

        // Sorts the ArrayList back to sorted by score as the insertion sort will need it, and it may be sorted by name.
        if (!isTimeSort)
            sortTime();

        // Picks starting index based on the level.
        int index = -1;
        switch (level) {
            case "Beginner":
                index = 9;
                break;
            case "Intermediate":
                index = 19;
                break;
            case "Expert":
                index = 29;
                break;
        }

        // Adds the GameEntry via insertion sort.
        // starts from end of level index. goes backwards until reaches a spot that is less than the element getting inserted. insets the element there.
        for (int j = index; j >= index - 9; j--) {
            if (entries.get(j) != null && entries.get(j).getTime() <= entry.getTime()) {
                entries.add(j + 1, entry);
                break;
            }
        }

        // Adds it if the part of ArrayList with the required level was all null.
        if (!entries.contains(entry))
            entries.add(index - 9, entry);

        // Removes the extra index added.
        entries.remove(index + 1);
    }

    public void remove(String username, String level) {
        GameEntry entryToRemove = new GameEntry(username, 0, level);
        int loc = 30;

        if (!entries.contains(entryToRemove)) {
            System.out.println("ERROR: The entry you'd like to remove does not exist in our records.");
            return;
        }

        // Iterates through the ArrayList backwards, from the last element, until it fins the required element to remove.
        for (ListIterator<GameEntry> itr =  entries.listIterator(entries.size()); itr.hasPrevious(); )  {
            GameEntry entry = itr.previous();
            loc -= 1;
            if (entry != null && entry.equals(entryToRemove)) {
                itr.remove();
                break;
            }
        }

        // Adds an extra null for the element that was removed to keep the size of that level region 10.
        if (loc >= 0 && loc < 10) {
            entries.add(9 ,null);
        } else if (loc < 20) {
            entries.add(19 ,null);
        } else if (loc < 30) {
            entries.add(29 ,null);
        }
    }

    public void sortName() {
        boolean swapped;

        // Bubble sort.
        // For loop to loop through every level region.
        for (int k = 0; k < 30; k += 10) {

            // For loop to bubble swap the max number of elements times, which is 10, or until all elements are sorted. (most likely will break and stop before max number of elements)
            for (int j = 0; j < 10; j++) {
                swapped = false;

                // For loop to loop through every element in the level region.
                // It swaps elements, when the first element is alphabetically ahead of the second, meaning the elements more alphabetically low (ie AAAA), will go the start of the ArrayList.
                for (int i = k; i < k + 9; i++) {
                    if (entries.get(i) != null && entries.get(i + 1) != null && entries.get(i).getUsername().compareTo(entries.get(i + 1).getUsername()) > 0) {
                        swap(i, i + 1);
                        swapped = true;
                    }
                }
                if (!swapped)
                    break;
            }
        }

        isTimeSort = false;
    }

    public void sortTime() {

        // Selections sort.
        // For loop to loop through every level region.
        for (int k = 0; k < 30; k += 10) {

            // For loop to loop through every element in the level region.
            for (int j = k; j < k + 10; j++) {
                int smallest = Integer.MAX_VALUE;
                int smallestIndex = -1;

                // For loop to loop through every element passed J.
                // It stores the smallest, by checking if the element is smaller than smallest.
                for (int i = j; i < k + 10; i++) {
                    if (entries.get(i) != null && entries.get(i).getTime() < smallest) {
                        smallest = entries.get(i).getTime();
                        smallestIndex = i;
                    }
                }

                if (smallestIndex != -1)
                    swap(j, smallestIndex);
            }
        }

        isTimeSort = true;
    }

    // return a string representation of 5 entries
    public String toString(){
        StringBuilder s = new StringBuilder();
        for (int k = 0; k < 30; k += 10) {
            s.append('\n');
            for (int i = k; i < k + 5; i++) {
                if (i > 0)
                    s.append('\n');
                if (entries.get(i) != null)
                    s.append(entries.get(i));
                else
                    s.append("Empty");
            }
        }
        return s.toString();
    }

    private void swap (int i, int j) {
        GameEntry temp = entries.get(i);
        entries.set(i, entries.get(j));
        entries.set(j, temp);
    }
}
