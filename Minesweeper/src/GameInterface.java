import java.util.Scanner;
import java.io.*;

public class GameInterface {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter the file you'd like to read:");
        String fileName = keyboard.nextLine();
        try {
            BufferedReader  in = new BufferedReader(new FileReader(fileName));
            while(in.ready()){
                System.out.println(in.readLine());
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Cannot open file for reading.");
        } catch (EOFException e) {
            System.out.println("Error: EOF encountered, file may be corrupted.");
        } catch (IOException e) {
            System.out.println("Error: Cannot read from file.");
        }


        keyboard.close();
    }
}
