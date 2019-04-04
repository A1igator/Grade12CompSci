/**
 * BonusStudentInfoTest.java
 * Name: Ali Abdoli
 * Date: MArch 19, 2019
 *
 *     Purpose: Java program to test the ability to read and write information from files and place them in
 *     objects from keyboard input.
 *
 * Methods:
 *     main - no return
 *     getNumUserInput - returns int
 */

import java.io.File;
import java.util.Scanner;

public class BonusStudentInfoTest {
    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        StudentIO info = new StudentIO();

        boolean keepGoingMain = true;

        // Do-while for main menu
        do {
            System.out.println("\nPlease select an option:\n" +
                    "1. Add students from a text file\n" +
                    "2. Read student records from a class file\n" +
                    "3. Manually add a student\n" +
                    "4. Save students to a backup text file\n" +
                    "5. Save students to a class file\n" +
                    "6. Output information of all students\n" +
                    "7. Output information of a student\n" +
                    "8. Output number of students\n" +
                    "9. Output average mark of all students\n" +
                    "10. Delete records of all students\n" +
                    "11. Exit");
            int mainMenuInput = getNumUserInput(null, 1, 11);

            switch (mainMenuInput) {

                // Add students from a text file
                case 1:
                    System.out.println("Please enter the file name (usually .txt):");
                    File currFile = new File(keyboard.nextLine());
                    info.fileReadMethod(currFile);

                    break;

                // Read student records from a class file
                case 2:
                    System.out.println("Please enter the file name (usually .dat):");
                    File classFile = new File(keyboard.nextLine());
                    info.objectInputMethod(classFile);

                    // Loops through everything in the class file and outputs all info it can give per StudentRecord.
                    for (int c = 0; c < 10; c++) {
                        if (info.getSaveObjRecord(c) == null)
                            break;
                        System.out.println(
                                c + ":\n" +
                                info.getSaveObjRecord(c) + "\t\tAnd the average is: " + info.getSaveObjRecord(c).calcAver() + "\n");
                    }

                    break;

                // Manually add a student
                case 3:
                    String name;
                    if (info.getCounter() == 10) {
                        System.out.println("Records are full. (max 10)");
                        break;
                    }

                    try {
                        System.out.println("What is their first and last name?");
                        name = keyboard.nextLine();
                        if (name.split(" ").length != 2)
                            throw new IndexOutOfBoundsException("Input Not First and Last Name");

                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Error: Invalid Input, please enter their first and last name (ie Ali Abdoli)\n");
                        name = null;
                    }

                    System.out.println("What is their address?");
                    String address = keyboard.nextLine();

                    System.out.println("What grade are they in? (1-12)");
                    int grade = getNumUserInput(null, 1, 12);

                    System.out.println("What is their math mark? (0-100)");
                    int mathMark = getNumUserInput(null, 0, 100);

                    System.out.println("What is their science mark? (0-100)");
                    int sciMark = getNumUserInput(null, 0, 100);

                    System.out.println("What is their english mark? (0-100)");
                    int engMark = getNumUserInput(null, 0, 100);

                    System.out.println("What is their computer science mark? (0-100)");
                    int compMark = getNumUserInput(null, 0, 100);

                    System.out.println();
                    if (name == null || grade == -1 || mathMark == -1 || sciMark == -1 || engMark == -1 || compMark == -1)
                        break;

                    // Only creates instance after it makes sure all input is valid.
                    info.setStudentRecord();
                    info.getStudentRecord().setName(name);
                    info.getStudentRecord().setAddress(address);
                    info.getStudentRecord().setGrade(grade);
                    info.getStudentRecord().setMathMark(mathMark);
                    info.getStudentRecord().setSciMark(sciMark);
                    info.getStudentRecord().setEngMark(engMark);
                    info.getStudentRecord().setCompMark(compMark);
                    info.setIncreaseCount();

                    break;

                // Save students to a backup text file
                case 4:
                    System.out.println("Please enter the file name (usually .txt):");
                    File backFile = new File(keyboard.nextLine());

                    info.writeFileMethod(backFile);

                    break;

                // Save students to a class file
                case 5:
                    System.out.println("Please enter the file name (usually .dat):");
                    File newFile = new File(keyboard.nextLine());

                    info.writeObjectMethod(newFile);

                    break;

                // Output information of all students
                case 6:
                    System.out.println("There are " + info.getCounter() + " student record(s) saved.");
                    if (info.getCounter() == 0)
                        break;
                    System.out.println("\nThe student records are:\n");

                    // Loops through everything stored (in saveRecord) and outputs all info it can give per StudentRecord.
                    for (int c = 0; c < info.getCounter(); c++) {
                        System.out.println(
                                c + ":\n" +
                                info.getSaveRecord(c) + "\t\tAnd the average is: " + info.getSaveRecord(c).calcAver() + "\n");
                    }

                    break;

                // Output information of a student
                case 7:
                    int infoUserInput;
                    boolean keepGoingInfo = true;

                    System.out.println("Please give the index of the student (0-9):");
                    int indexInput = getNumUserInput(info ,0 ,9);

                    if (indexInput == -1)
                        break;

                    // Do-while for user to pick information they would like from a student record.
                    do {
                            System.out.println("\nPlease select an option:\n" +
                                    "1. Name\n" +
                                    "2. Address\n" +
                                    "3. Grade\n" +
                                    "4. Math mark\n" +
                                    "5. Science mark\n" +
                                    "6. English mark\n" +
                                    "7. Computer Science mark\n" +
                                    "8. Average mark\n" +
                                    "9. All information\n" +
                                    "10. Select a new student\n" +
                                    "11. Go back to main menu");
                            infoUserInput = getNumUserInput(null, 1, 11);

                        switch (infoUserInput) {
                            case 1:
                                System.out.println(info.getSaveRecord(indexInput).getName());
                                break;
                            case 2:
                                System.out.println(info.getSaveRecord(indexInput).getAddress());
                                break;
                            case 3:
                                System.out.println(info.getSaveRecord(indexInput).getGrade());
                                break;
                            case 4:
                                System.out.println(info.getSaveRecord(indexInput).getMathMark());
                                break;
                            case 5:
                                System.out.println(info.getSaveRecord(indexInput).getSciMark());
                                break;
                            case 6:
                                System.out.println(info.getSaveRecord(indexInput).getEngMark());
                                break;
                            case 7:
                                System.out.println(info.getSaveRecord(indexInput).getCompMark());
                                break;
                            case 8:
                                System.out.println(info.getSaveRecord(indexInput).calcAver());
                                break;
                            case 9:
                                System.out.println(info.getSaveRecord(indexInput));
                                break;
                            case 10:
                                System.out.println("Please give the index of the student (0-9):");
                                int posIndexInput = getNumUserInput(info, 0, 9);

                                if (posIndexInput != -1)
                                    indexInput = posIndexInput;
                                break;
                            case 11:
                                // Exits loop
                                keepGoingInfo = false;
                                break;
                        }
                    } while (keepGoingInfo);

                    break;

                // Output number of students
                case 8:
                    System.out.println("There are " + info.getCounter() + " student records saved.");

                    break;

                // Output average mark of all students
                case 9:
                    System.out.println(info.calcAllAver());

                    break;

                // Delete records of all students
                case 10:
                    // Creates new StudentIO instance and gets rid of old one.
                    info = new StudentIO();

                    break;

                // Exit
                case 11:
                    // Exists loop
                    keepGoingMain = false;

                    break;
            }
        } while(keepGoingMain);
    }

    // Method to get int input from user. It does error check to make sure input is valid.
    private static int getNumUserInput(StudentIO info, int min, int max) {
        int input;
        try {
            input = Integer.parseInt(keyboard.nextLine());

            if (input < min || input > max)
                throw new NumberFormatException("Number Not From " + min + " to " + max);

            // Ignores errors for calls that do not require info.
            if (info != null) {
                if (info.getSaveRecord(input) == null)
                    throw new IndexOutOfBoundsException("Student Not Found");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid Input, please enter a number from " + min + " to " + max + ".");
            input = -1;

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Student record does not exist.");
            input = -1;
        }

        return input;
    }
}
