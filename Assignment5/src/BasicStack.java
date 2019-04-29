/**
 * BasicStack.java
 * Name: Ali Abdoli
 * Date: April 23, 2019
 *
 *     Purpose: Java program to implement a stack.
 *
 * Methods:
 *     empty - returns boolean
 *     peek - returns Object
 *     pop - returns Object
 *     push(Object element) - returns Object
 *     search(Object element) - returns int
 *     toString - returns String
 *     size - returns int
 *     remove - no return
 */

import java.util.ArrayList;
import java.util.Arrays;

public class BasicStack extends BasicStackTest {
    private ArrayList<Object> stack;

    BasicStack() {
        stack = new ArrayList<>();
    }

    public boolean empty() {
        return stack.size() == 0;
    }

    public Object peek() {
        return empty() ? null : stack.get(stack.size() - 1);
    }

    public Object pop() {
        Object element = empty() ? null : stack.get(stack.size() - 1);
        if (element != null)
            stack.remove(stack.size() - 1);
        return element;
    }
    
    public Object push(Object element) {
        if (stack.size() >= 10)
            return "Stack is full (max 10)";
        stack.add(stack.size(), element);
        return element;
    }

    public int search(Object element) {
        int index = stack.indexOf(element);
        return index == -1 ? -1 : stack.size() - 1 - index;
    }

    public String toString() {
        return Arrays.toString(stack.toArray());
    }

    public int size() {
        return stack.size();
    }

    public void remove() {
        boolean keepGoing = true;

        do {
            System.out.println("\nPlease select an option:\n" +
                    "1. Based on index\n" +
                    "2. Based on element String\n" +
                    "3. go back to main menu");
            int userInput = getNumUserInput(1, 9);
            if (userInput == -1)
                continue;
            switch (userInput) {
                case 1:
                    System.out.println("Please give the index of String you'd like to remove:");
                    stack.remove(keyboard.nextLine());
                    break;
                case 2:
                    System.out.println("Please give the text of String you'd like to remove:");
                    stack.removeIf(x -> (x.equals(keyboard.nextLine())));
                    break;
                case 3:
                    keepGoing = false;
                    break;
            }
        } while(keepGoing);

    }
}
