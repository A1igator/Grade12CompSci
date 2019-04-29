/**
 * StudentIO.java
 * Name: Ali Abdoli
 * Date: MArch 19, 2019
 *
 *     Purpose: Java program for input/output into/from text, and class files, and instances of StudentRecord.
 *     Also creates said instances.
 *
 * Methods:
 *     fileReadMethod - no return
 *     writeFileMethod - no return
 *     writeObjectMethod - no return
 *     objectInputMethod - no return
 *     getStudentRecord - returns StudentRecord
 *     getSaveRecord - returns StudentRecord
 *     getStudentRecord - returns StudentRecord
 *     getSaveObjRecord - returns StudentRecord
 *     getCounter - return int
 *     setStudentRecord - no return
 *     setIncreaseCount - no return
 *     calcAllAver - returns float
 *     toString - returns String
 */

import java.io.*;

public class StudentIO {
    private StudentRecord[] saveRecord, saveObjRecord;
    private int counter;

    // Constructor to initialize new StudentRecord arrays and start counter.
    public StudentIO() {
        saveRecord = new StudentRecord[10];
        saveObjRecord = new StudentRecord[10];
        counter = 0;
    }

    // Reads from a text file into saveRecord.
    public void fileReadMethod(File myFile) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(myFile));

            while (in.ready()) {
                if (counter == 10) {
                    System.out.println("Could not fit in all of the file. Records are full. (max 10)");
                    break;
                }

                saveRecord[counter] = new StudentRecord(in.readLine());
                counter++;
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

    // Writes saveRecord to a text file.
    public void writeFileMethod(File myFile) {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(myFile));

            for (StudentRecord aStudent : saveRecord) {
                if (aStudent == null)
                    break;
                out.println(aStudent);
            }

            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Cannot open file for writing.");
        } catch (IOException e) {
            System.out.println("Error: Cannot write to file.");
        }
    }

    // Writes saveRecord object to a class file.
    public void writeObjectMethod(File myFile) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(myFile));

            out.writeObject(saveRecord);

            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Cannot open file for writing.");
        } catch (IOException e) {
            System.out.println("Error: Cannot write to file.");
        }
    }

    // Reads a class file into saveObjectRecord.
    public void objectInputMethod(File myFile) {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(myFile));

            saveObjRecord = (StudentRecord[])in.readObject();

            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Cannot open file for writing.");
        } catch (ClassNotFoundException e){
            System.out.println("Error: Cannot open class.");
        } catch (IOException e) {
            System.out.println("Error: Cannot write to file.");
        }
    }

    // Get saveRecord StudentRecord object based on counter.
    public StudentRecord getStudentRecord() {
        return saveRecord[counter];
    }

    // Get saveRecord StudentRecord object based on any index (passed in).
    public StudentRecord getSaveRecord(int loc) {
        return saveRecord[loc];
    }

    // Get saveObjRecord StudentRecord object based on any index (passed in).
    public StudentRecord getSaveObjRecord(int loc) {
        return saveObjRecord[loc];
    }

    public int getCounter() {
        return counter;
    }

    // Inserts new StudentRecord into saveRecord.
    public void setStudentRecord() {
        saveRecord[counter] = new StudentRecord();
    }

    public void setIncreaseCount() {
        counter++;
    }

    public float calcAllAver() {
        float sum = 0;
        for (StudentRecord student: saveRecord) {
            if (student == null)
                break;
            sum += student.calcAver();
        }
        return sum/(float)saveRecord.length;
    }

    // Overrides the toString method to display the String returned when System.out.print is applied to this object.
    public String toString() {
        StringBuilder studString = new StringBuilder();
        for (StudentRecord student: saveRecord) {
            if (student == null)
                break;
            studString.append(student);
            studString.append("\n");
        }
        return studString.toString();
    }
}
