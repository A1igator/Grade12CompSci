/**
 * CheckNumberTest.java
 * Name: Ali Abdoli
 * Date: February 15, 2018
 *
 *     Purpose: Java program to show a menu, to let the user input a number, using the methods in the Keyboard class.
 *     It will output the return of one of the methods in the SymImg, and CheckNumber depending on what the user selects in the menu.
 *
 * Methods:
 *     getUserNum – returns int
 *     main - no returns
 */


import static java.lang.System.out;

public class CheckNumberTest {

    public static int getUserNum() {
        out.println("\nPlease type a number you would like to use:");
        return Keyboard.getInteger();
    }

    public static void main(String[] args) {
        boolean loopAgain;
        boolean backToMenu;

        do {
            backToMenu = false;

            out.println("\nPlease select an option: \n" +
                    "1.Check attributes of a number of your choosing\n" +
                    "2.Create Symmetrical Images based on a number of your choosing\n" +
                    "3.Exit the program");

            int userInputMainMenu = Keyboard.getInteger();

                if (userInputMainMenu == 1) {
                    boolean loopCheckNumAgain;
                    int userInputNum = CheckNumberTest.getUserNum();
                    CheckNumber checkNumRef = new CheckNumber();

                    do {
                        loopCheckNumAgain = false;
                        checkNumRef.num = userInputNum;

                        out.println("\nPlease select an option: \n" +
                                "1.Check if " + userInputNum + " is positive or negative\n" +
                                "2.Check to see if " + userInputNum + " is a prime number\n" +
                                "3.Get the number of digits in " + userInputNum + "\n" +
                                "4.Check to see if " + userInputNum + " is a palindrome\n" +
                                "5.Choose a different number\n" +
                                "6.Go back to main menu");

                        int userInputMenuCheckNum = Keyboard.getInteger();

                        switch (userInputMenuCheckNum) {
                            case 1:
                                if (checkNumRef.checkPos()) {
                                    out.println("The Number " + userInputNum + " is positive");
                                } else {
                                    out.println("The Number " + userInputNum + " is not positive");
                                }
                                break;
                            case 2:
                                if (checkNumRef.checkPrime()) {
                                    out.println("The Number " + userInputNum + " is prime");
                                } else {
                                    out.println("The Number " + userInputNum + " is not prime");
                                }
                                break;
                            case 3:
                                out.println("The Number " + userInputNum + " has " + checkNumRef.getDigitNum() + " digit(s)");
                                break;
                            case 4:
                                if (checkNumRef.checkPalindrome()) {
                                    out.println("The Number " + userInputNum + " is a palindrome");
                                } else {
                                    out.println("The Number " + userInputNum + " is not a palindrome");
                                }
                                break;
                            case 5:
                                userInputNum = CheckNumberTest.getUserNum();
                                loopCheckNumAgain = true;
                                break;
                            case 6:
                                backToMenu = true;
                                break;
                            default:
                                out.println("That is not a possible option");
                                loopCheckNumAgain = true;
                        }

                } while (loopCheckNumAgain);

            } else if (userInputMainMenu == 2) {
                SymImg symImgRef = new SymImg();
                boolean loopSymImgAgain;
                int userInputNum = CheckNumberTest.getUserNum();

                do {
                    loopSymImgAgain = false;

                    if (userInputNum < 0) {
                        out.println("The number has to be positive");
                        userInputNum = CheckNumberTest.getUserNum();
                        loopSymImgAgain = true;

                    } else {
                        symImgRef.num = userInputNum;

                        out.println("\nPlease select an option: \n" +
                                "1.Draw " + userInputNum + " symmetrical image\n" +
                                "2.Choose a different number\n" +
                                "3.Go back to main menu");

                        int userInputSymImgMenu = Keyboard.getInteger();

                        switch (userInputSymImgMenu) {
                            case 1:
                                out.println(symImgRef.makeSymImg());
                                break;
                            case 2:
                                userInputNum = CheckNumberTest.getUserNum();
                                loopSymImgAgain = true;
                                break;
                            case 3:
                                backToMenu = true;
                                break;
                            default:
                                out.println("That is not a possible option");
                                loopSymImgAgain = true;

                        }
                    }

                } while (loopSymImgAgain);

            }

            else if (userInputMainMenu == 3)
                return;

            else {
                out.println("That is not a possible option");
                backToMenu = true;
            }

            if (backToMenu)
                continue;

            do {
                out.println("\nDo you want to try a different option? (Y/N):");
                char answer = Keyboard.getCharacter();

                if (answer == 'Y' || answer == 'n') {
                    loopAgain = true;
                    break;
                }
                else if (answer == 'N' || answer == 'n') {
                    loopAgain = false;
                    break;
                }
                else {
                    out.println("\nPlease input either 'Y' or 'N'");
                }

            } while (true);

            if (!loopAgain)
                break;

        } while (true);
    }
}
