/**
 * StudentRecord.java
 * Name: Ali Abdoli
 * Date: MArch 19, 2019
 *
 *     Purpose: Java program for a class to create a student record.
 *
 * Methods:
 *     StudentRecord(String studInfo) - overloading constructor - no return
 *     setName name - no return
 *     setAddress - no return
 *     setGrade - no return
 *     setMathMark - no return
 *     setSciMark - no return
 *     setEngMark - no return
 *     setCompMark - no return
 *     getName - returns String
 *     getAddress - return String
 *     getGrade - returns int
 *     getMathMark - returns int
 *     getSciMark - returns int
 *     getEngMark - returns int
 *     getCompMark - returns int
 *     calcAver - returns float
 *     toString - returns String
 */

// Has to be Serializable so object can be represented as a sequence of bytes that includes the object's data
// as well as information about the object's type and the types of data stored in the object.
public class StudentRecord implements java.io.Serializable {
    private String firstName, lastName, address;
    private int grade, mathMark, sciMark, engMark, compMark;

    // Constructor to initialize everything to "unknown" (integer unknown is -1), when nothing is passed in.
    public StudentRecord() {
        firstName = "unknown";
        lastName = "unknown";
        address = "unknown";
        grade = -1;
        mathMark = -1;
        sciMark = -1;
        engMark = -1;
        compMark = -1;
    }

    // Overloaded constructor to initialize everything based on a String passed in.
    public StudentRecord(String studInfo) {
        String[] studInfoString = studInfo.split(", ");
        firstName = studInfoString[0];
        lastName = studInfoString[1];
        address = studInfoString[2];
        grade = Integer.parseInt(studInfoString[3]);
        mathMark = Integer.parseInt(studInfoString[4]);
        sciMark = Integer.parseInt(studInfoString[5]);
        engMark = Integer.parseInt(studInfoString[6]);
        compMark = Integer.parseInt(studInfoString[7]);
    }

    public void setName(String name) {
        String[] nameArray = name.split(" ");
        firstName = nameArray[0];
        lastName = nameArray[1];
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setMathMark(int mathMark) {
        this.mathMark = mathMark;
    }

    public void setSciMark(int sciMark) {
        this.sciMark = sciMark;
    }

    public void setEngMark(int engMark) {
        this.engMark = engMark;
    }

    public void setCompMark(int compMark) {
        this.compMark = compMark;
    }

    public String getName() {
        return firstName + ' ' + lastName;
    }

    public String getAddress() {
        return address;
    }

    public int getGrade() {
        return grade;
    }

    public int getMathMark() {
        return mathMark;
    }

    public int getSciMark() {
        return  sciMark;
    }

    public int getEngMark() {
        return engMark;
    }

    public int getCompMark() {
        return compMark;
    }

    public float calcAver() {
        return (float)(mathMark + sciMark + engMark + compMark)/4.0f;
    }

    // Overrides the toString method to display the String returned when System.out.print is applied to this object.
    public String toString() {
        return String.format("%s, %s, %s, %s, %s, %s, %s, %s", firstName, lastName, address, grade, mathMark, sciMark, engMark, compMark);
    }
}
