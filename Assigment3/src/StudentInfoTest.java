/*************************************************
 //    File name:  StudentInfoTest
 //
 //    Purpose: to test the ability to read and write information from files and place them in
 //    objects
 //
 **************************************************/

import java.io.File;

public class StudentInfoTest {

    public static void main(String args[]) {

        StudentIO info = new StudentIO();

        // define the File to open
        File currFile = new File("studInfo.txt");

        /***********************************************************/
        // open and read the original text file and instantiate
        // the objects for the arrays in the SavePtIO class
        /**********************************************************/

        info.fileReadMethod(currFile);


        // add another record object into the student record array saveRecord[]
        info.setStudentRecord();

        //retrieve the object and set the new values in the record.
        info.getStudentRecord().setName("Curious George");
        info.getStudentRecord().setGrade(10);
        info.getStudentRecord().setMathMark(76);
        info.getStudentRecord().setSciMark(59);
        info.getStudentRecord().setEngMark(56);
        info.getStudentRecord().setCompMark(78);

        info.setIncreaseCount(); //counter in StudentIO class needs to be increased.

        //print out all of the  entries using the toString()
        System.out.println(info);


        /*************************************************************/
        // write the object out as a text file with the new addition
        /*************************************************************/
        File backFile = new File("studentRecBackup.txt");

        info.writeFileMethod(backFile);

        /************************************************************/
        //read the backupfile and see if you can import it too
        /************************************************************/

        info.fileReadMethod(backFile);

        //print out all of the  entries using the toString()
        System.out.println(info);

        /*************************************************************/
        // export file as a class file.
        /*************************************************************/
        File newFile = new File("studentInfo.dat");

        info.writeObjectMethod(newFile);


        /*************************************************************/
        // import the file as a class
        // to prove you have written the file,  load and then show
        /************************************************************/

        //remember the second array saveObjData was made for this part


        info.objectInputMethod(newFile);

        //Final check of your results.

        System.out.println("There are " + info.getCounter() + " student records saved in the array.\n" + "The student records are: ");

        for (int c = 0; c < info.getCounter(); c++) {
            System.out.print(c + ":\n");
            System.out.print(info.getSaveObjRecord(c));
            System.out.print("\t\tAnd the average is: " + info.getSaveObjRecord(c).calcAver());
            System.out.println();
        }

    }
}
