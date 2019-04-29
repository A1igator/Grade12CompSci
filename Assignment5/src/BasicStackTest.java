/**
 * BasicStackTest.java
 * Name: Ali Abdoli
 * Date: April 23, 2019
 *
 *     Purpose: Java program to test the stack.
 *
 * Methods:
 *     getNumUserInput - returns boolean
 */

import java.util.Scanner;

public class BasicStackTest {
    public final static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        boolean keepGoing = true;
        BasicStack stack = new BasicStack();

        do {
            System.out.println("\nPlease select an option:\n" +
                    "1. push\n" +
                    "2. pop\n" +
                    "3. Is the stack empty?\n" +
                    "4. How many numbers in the stack?\n" +
                    "5. peek\n" +
                    "6. search\n" +
                    "7. remove\n" +
                    "8. show\n" +
                    "9. exit");
            int userInput = getNumUserInput(1, 9);
            if (userInput == -1)
                continue;
            switch (userInput) {
                case 1:
                    System.out.println("Please give the text of String you'd like to push:");
                    System.out.println(stack.push(keyboard.nextLine()));
                    break;
                case 2:
                    System.out.println(stack.pop());
                    break;
                case 3:
                    System.out.println(stack.empty());
                    break;
                case 4:
                    System.out.println(stack.size());
                    break;
                case 5:
                    System.out.println(stack.peek());
                    break;
                case 6:
                    System.out.println("Please give the text of String you'd like to search for:");
                    System.out.println(stack.search(keyboard.nextLine()));
                    break;
                case 7:
                    stack.remove();
                    break;
                case 8:
                    System.out.println(stack);
                    break;
                case 9:
                    keepGoing = false;
                    break;
            }
        } while(keepGoing);

        keyboard.close();
    }

    // Method to get int input from user. It checks whether input is valid.
    public static int getNumUserInput(int min, int max) {
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
}
