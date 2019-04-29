/**
 * GameInterface.java
 * Name: Ali Abdoli
 * Date: April 13, 2019
 *
 *     Purpose: Java program to provide a menu that applies operations on the stored
 *     entries, with user input.
 * Code used:
 *      Profanity filter: It is an implementation of https://gist.github.com/PimDeWitte/c04cc17bc5fa9d7e3aee6670d4105941 .
 *
 * Methods:
 *     main - no return
 *     fileAdd - no return
 *     userAdd - no return
 *     userRemove - no return
 *     getNumUserInput - returns int
 *     loadConfigs - no returns
 *     badWordsFound - returns ArrayList<String>
 *     getStringUserInput - returns String
 */

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameInterface {
    private final static DisplayScore scoreDisplay = new DisplayScore();
    private final static Scanner keyboard = new Scanner(System.in);

    private final static Map<String, String[]> words = new HashMap<>();
    private static int largestWordLength = 0;

    public static void main(String[] args) {
        boolean keepGoing = true;

        loadConfigs();

        do {
            System.out.println("\nPlease select an option:\n" +
                    "1. Load entries from a file.\n" +
                    "2. Manually add an entry.\n" +
                    "3. Remove an entry.\n" +
                    "4. Sort based on name.\n" +
                    "5. Sort based on time. (lower is better)\n" +
                    "6. Display top 5 entries in each level.\n" +
                    "7. Exit.");
            int userInput = getNumUserInput(1, 7);
            if (userInput == -1)
                continue;
            switch (userInput) {
                case 1:
                    fileAdd();
                    break;
                case 2:
                    userAdd();
                    break;
                case 3:
                    userRemove();
                    break;
                case 4:
                    scoreDisplay.sortName();
                    break;
                case 5:
                    scoreDisplay.sortTime();
                    break;
                case 6:
                    System.out.println(scoreDisplay);
                    break;
                case 7:
                    keepGoing = false;
                    break;
            }
        } while(keepGoing);

        keyboard.close();
    }

    // Add file data to DisplayScore entries.
    private static void fileAdd() {
        System.out.println("\nPlease enter the file you'd like to read: (profane usernames will be censored)");
        String fileName = getStringUserInput();

        if (fileName.length() == 0)
            return;

        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            while (in.ready()) {
                String[] entry = in.readLine().split(", ");
                scoreDisplay.add(filterProfanity(entry[0]), Integer.parseInt(entry[1]), entry[2]);
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Cannot open file for reading.");
        } catch (EOFException e) {
            System.out.println("Error: EOF encountered, file may be corrupted.");
        } catch (IOException e) {
            System.out.println("Error: Cannot read from file.");
        }
    }

    // Let user manually add an entry to DisplayScore entries.
    private static void userAdd() {
        System.out.println("\nPlease enter the username of the player you wish to add: (profane usernames will be censored)");
        String username = getStringUserInput();
        if (username.length() == 0)
            return;
        System.out.println("Please enter the time of the player you wish to add: [0 to " + Integer.MAX_VALUE + ']');
        int time = getNumUserInput(0, Integer.MAX_VALUE);
        if (time == -1)
            return;
        System.out.println("Please enter the level of the player you wish to add: [Beginner, Intermediate, Expert]");
        String level = getStringUserInput("Beginner", "Intermediate", "Expert");
        if (level.length() == 0)
            return;
        scoreDisplay.add(username, time, level);
    }

    // Let user remove an entry from DisplayScore entries.
    private static void userRemove() {
        System.out.println("\nPlease enter the username of the player you wish to remove:");
        String username = getStringUserInput();
        if (username.length() == 0)
            return;
        System.out.println("Please enter the level of the player you wish to remove: [Beginner, Intermediate, Expert]");
        String level = getStringUserInput("Beginner", "Intermediate", "Expert");
        if (level.length() == 0)
            return;
        scoreDisplay.remove(username, level);
    }

    // Method to get int input from user. It checks whether input is valid.
    private static int getNumUserInput(int min, int max) {
        int input;

        try {
            input = Integer.parseInt(keyboard.nextLine());

            if (input < min || input > max)
                throw new NumberFormatException("Number Not From " + min + " to " + max);

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid Input, please enter an integer from " + min + " to " + max + ".");
            input = -1;
        }

        return input;
    }

    // Loads list of profane words from google docs.
    private static void loadConfigs() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new URL("https://docs.google.com/spreadsheets/d/1hIEi2YG3ydav1E06Bzf2mQbGZ12kh2fe4ISgLg_UBuM/export?format=csv").openConnection().getInputStream()));
            String line;
            int counter = 0;
            while((line = reader.readLine()) != null) {
                counter++;
                String[] content;
                try {
                    content = line.split(",");
                    if(content.length == 0) {
                        continue;
                    }
                    String word = content[0];
                    String[] ignore_in_combination_with_words = new String[]{};
                    if(content.length > 1) {
                        ignore_in_combination_with_words = content[1].split("_");
                    }

                    if(word.length() > largestWordLength) {
                        largestWordLength = word.length();
                    }
                    words.put(word.replaceAll(" ", ""), ignore_in_combination_with_words);

                } catch(Exception e) {
                    e.printStackTrace();
                }

            }
            System.out.println("Loaded " + counter + " words to filter out.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Iterates over a String input and checks whether a cuss word was found in a list, then checks if the word should be ignored (e.g. bass contains the word *ss).
    private static ArrayList<String> profaneWordsFound(String input) {

        // remove leetspeak.
        input = removeLeet(input);
        ArrayList<String> profaneWords = new ArrayList<>();

        // iterate over each letter in the word.
        for(int start = 0; start < input.length(); start++) {
            // from each letter, keep going to find bad words until either the end of the sentence is reached, or the max word length is reached.
            for(int offset = 1; offset < (input.length()+1 - start) && offset < largestWordLength; offset++)  {
                String wordToCheck = input.substring(start, start + offset);
                if(words.containsKey(wordToCheck)) {
                    // for example, if you want to say the word bass, that should be possible.
                    String[] ignoreCheck = words.get(wordToCheck);
                    boolean ignore = false;
                    for (String word: ignoreCheck) {
                        if(input.contains(word)) {
                            ignore = true;
                            break;
                        }
                    }
                    if(!ignore) {
                        profaneWords.add(wordToCheck);
                    }
                }
            }
        }

        return profaneWords;
    }

    // Removes numbers as characters and makes input all lowercase for easier comparison.
    private static String removeLeet(String input) {
        input = input.replaceAll("1","i");
        input = input.replaceAll("!","i");
        input = input.replaceAll("3","e");
        input = input.replaceAll("4","a");
        input = input.replaceAll("@","a");
        input = input.replaceAll("5","s");
        input = input.replaceAll("7","t");
        input = input.replaceAll("0","o");
        input = input.replaceAll("9","g");

        return input.toLowerCase().replaceAll("[^a-zA-Z]", "");
    }

    private static String filterProfanity(String input) {
        // Filter profanity. Uses regex to find where the profane word is, and turns it into stars.
        ArrayList<String> profaneWords = profaneWordsFound(input);
        char[] inputChars = input.toCharArray();
        for (String badWord : profaneWords) {

            Matcher match = Pattern.compile(badWord).matcher(removeLeet(input));

            while (match.find()) {
                for (int i = match.start(); i < match.end(); i++)
                    inputChars[i] = '*';
            }
        }

        return String.valueOf(inputChars);
    }

    // Method to get String input from user. It checks whether input is valid. It also filters profanity by turning it in stars.
    private static String getStringUserInput(String... allowed) {
        String input = keyboard.nextLine();

        if (input.length() == 0)
            System.out.println("Error: Empty input, please type something.");

        if (allowed.length > 0 && !Arrays.asList(allowed).contains(input)) {
            System.out.println("Error: Invalid input, please enter an accepted input. " + Arrays.toString(allowed));
            input = "";
        }

        if (allowed.length == 0) {
            input = filterProfanity(input);
        }

        return input;
    }
}
