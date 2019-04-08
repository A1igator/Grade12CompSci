import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.EOFException;
import java.io.IOException;

public class GameInterface {
    private static DisplayScore scoreDisplay = new DisplayScore();
    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        boolean keepGoing = true;
        do {
            System.out.println("Please select an option:\n" +
                    "1. Add entries based on file.\n" +
                    "2. manually add an entry.\n" +
                    "3. Remove an entry.\n" +
                    "4. Sort based on name.\n" +
                    "5. Sort based on time. (lower is better)\n" +
                    "6. Display all entries.\n" +
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
            }
        } while(keepGoing);

        keyboard.close();
    }

    private static void fileAdd() {
        System.out.println("Please enter the file you'd like to read:");
        String fileName = keyboard.nextLine();
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            while (in.ready()) {
                String[] entry = in.readLine().split(", ");
                String username = entry[0];
                int time = Integer.parseInt(entry[1]);
                String level = entry[2];
                scoreDisplay.add(username, time, level);
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

    private static void userAdd() {
        System.out.println("Please enter the username of the player you wish to add:");
        String username = keyboard.nextLine();
        System.out.println("Please enter the time of the player you wish to add:");
        int time = Integer.parseInt(keyboard.nextLine());
        System.out.println("Please enter the level of the player you wish to add:");
        String level = keyboard.nextLine();
        scoreDisplay.add(username, time, level);
    }

    private static void userRemove() {
        System.out.println("Please enter the username of the player you wish to remove:");
        String username = keyboard.nextLine();
        System.out.println("Please enter the level of the player you wish to remove:");
        String level = keyboard.nextLine();
        scoreDisplay.remove(username, level);
    }

    // Method to get int input from user. It does error check to make sure input is valid.
    private static int getNumUserInput(int min, int max) {
        int input;
        try {
            input = Integer.parseInt(keyboard.nextLine());

            if (input < min || input > max)
                throw new NumberFormatException("Number Not From " + min + " to " + max);

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid Input, please enter a number from " + min + " to " + max + ".");
            input = -1;
        }
        return input;
    }
}
