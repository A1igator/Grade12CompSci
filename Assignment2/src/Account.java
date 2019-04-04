/**
 * Account.java
 * Name: Ali Abdoli
 * Date: February 25, 2019
 *
 *     Purpose: Java program for a bank account class, which can hold values balance, first name and last name and various methods.
 *
 * Methods:
 *     Account(String lName, String fName, double bal) - overloaded constructor - no return.
 *     credit – no return
 *     debit - no return
 *     getBalance - returns float
 *     getName - return String
 *     setFirstName - no return
 *     setLastName - no return
 *     toString - no return
 *
 */

import static java.lang.System.out;

// String.format("%.02f", var) makes a float variable always have 2 decimal places. This is used in many methods.

public class Account {
    private float balance;
    private String firstName;
    private String lastName;

    // Constructor which sets the balance to 0 if nothing is passed in.
    public Account() {
        balance = 0;
        firstName = "Unknown";
        lastName = "User";
    }

    // Overloaded constructor to change the instance variables depending on what is passed in to the class.
    // Gives error and assumes balance under $0.00 is $0.00.
    public Account(String lName, String fName, double bal) {
        if (bal < 0) {
            balance = 0;
            out.println("Balance value is invalid. Assumed balance of $" + String.format("%.02f", balance) + ".\n");
        } else
            balance = (float)bal;

        firstName = fName;
        lastName = lName;
    }

    // Adds to the instance object's balance by the amount entered (puts money in).
    public void credit(double amount) {
        balance+=amount;
    }

    // Reduces the instance object's balance by the amount entered (takes money out).
    // Gives error if there is not enough money in the balance as the amount requested.
    public void debit(double amount) {
        if (balance - amount < 0)
            out.println("There is not enough money in " + firstName + " " + lastName + "'s account to withdraw $" + String.format("%.02f", amount) + ". Only $" + String.format("%.02f", balance) + " available.\n");
        else
            balance-=amount;
    }

    // Get's the instance object's balance.
    public float getBalance() {
        return balance;
    }

    // Get's the instance object's full name.
    public String getName() {
        return firstName + " " + lastName + "\n";
    }

    // Changes the instance object's first name.
    public void setFirstName(String fName) {
        firstName = fName;
    }

    // Changes the instance object's last name.
    public void setLastName(String lName) {
        lastName = lName;
    }

    // Overrides the Java toString method, therefore the return here will display when one System.outs an instance object. (Also if one does instanceObj.toString())
    public String toString() {
        return  firstName + " " + lastName + " has $" + String.format("%.02f", balance) + " in their account.\n";
    }
}
