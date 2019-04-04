/**
 * SymImg.java
 * Name: Ali Abdoli
 * Date: February 15, 2018
 *
 *     Purpose: Java program to displays multiple symmetrical image of diamonds based on the value of num.
 *
 * Methods:
 *     makeSymImg – returns String
 */

public class SymImg {
    public int num;
    public int NUMROW = 5;

    // Start with an empty string, SymImg.
    // Loop the integer, num, which is the number of symmetrical images needed, times.
    // Loop from 0 to integer, NUMROW, which is a constant showing the number of rows from the top of each image to the the center.
    // Add space to symImg String, NUMROW minus the row you are on, times.
    // Add the character, o, the row you are on times 2 minus 1, times.
    // Loop backwards from integer, NumRow minus 1, to 0.
    // Add space to symImg String, NUMROW minus the row you are on, times.
    // Add the character, o, the row you are on times 2 minus 1, times.
    public String makeSymImg() {
        String symImg = "";
        for (int numSymImg = 0; numSymImg < num; numSymImg++) {
            for (int row = 1; row <= NUMROW; row++) {
                for (int j = 1; j <= NUMROW - row; j++) {
                    symImg += ' ';
                }
                for (int j = 1; j <= row * 2 - 1; j++) {
                    symImg += 'o';
                }
                symImg += '\n';
            }
            for (int row = NUMROW - 1; row > 0; row--) {
                for (int j = 1; j <= NUMROW - row; j++) {
                    symImg += ' ';
                }
                for (int j = 1; j <= row * 2 - 1; j++) {
                    symImg += 'o';
                }
                symImg += '\n';
            }
        }
        return symImg;
    }
}
