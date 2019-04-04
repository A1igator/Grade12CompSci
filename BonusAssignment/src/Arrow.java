/**
 * Arrow.java
 * Name: Ali Abdoli
 * Date: March 1, 2019
 *
 *     Purpose: Java program for an Arrow class, with attributes that makes the arrow such as width, height and the character used.
 *
 * Methods:
 *     Arrow(int height, int width, char madeOf) - overloaded constructor - no return.
 *     toString – overloaded method - return String
 *     main - no return
 *
 */

import java.util.Scanner;
import java.lang.StringBuilder;

public class Arrow {
    private char[][] arrowGrid;
    private int height;
    private int width;
    private char madeOf;

    public Arrow() {
        height = 7;
        width = 7;
        madeOf = 'X';
        createArrow();
    }

    public Arrow(int height, int width, char madeOf) {
        this.height = height;
        this.width = width;
        this.madeOf = madeOf;
        createArrow();
    }

    private void createArrow() {
        arrowGrid = new char[height][width];
        for (int row = 0; row < height; row++) {
            if (row < height/2) {
                int j;
                for (j = 0; j < width / 2 - row; j++) {
                    arrowGrid[row][j] = ' ';
                }
                for (int i = 0; i < width - (j * 2); i++) {
                    arrowGrid[row][i + j] = madeOf;
                }
            } else {
                int k;
                for (k = 0; k < width/2; k++) {
                    arrowGrid[row][k] = ' ';
                }
                arrowGrid[row][k+1] = madeOf;
            }
        }
    }

    public String toString() {
        StringBuilder arrow = new StringBuilder();
        for (char[] row: arrowGrid) {
            for (char column: row) {
                arrow.append(column);
            }
            arrow.append('\n');
        }
        return arrow.toString();
    }

    public static void main(String[] args) {
        int width = 0;
        int height = 0;
        String madeOfInput = "--";
        Scanner userInput = new Scanner(System.in);
        while (height <= 0) {
            System.out.println("Please enter the height of the arrow:");
            height = userInput.nextInt();
            if (height <= 0)
                System.out.println("Height has to be more than 0. Please try again.");
        }
        while (width % 2 == 0 || width <= 0) {
            System.out.println("Please enter the width of the arrow (Has to be an odd number) (Keep in mind your width may be less depending on height):");
            width = userInput.nextInt();
            if (width % 2 == 0)
                System.out.println("width has to be an odd number. Please try again.");
            else if (width <= 0)
                System.out.println("Width has to be more than 0. Please try again.");
        }
        while (madeOfInput.length() > 1) {
            System.out.println("Please enter the character the arrow will be made of:");
            madeOfInput = userInput.next();
            if (madeOfInput.length() > 1)
                System.out.println("Please only enter one character.");
        }
        char madeOf = madeOfInput.charAt(0);
        Arrow arrow1 = new Arrow(height, width, madeOf);
        System.out.println(arrow1);
    }
}
