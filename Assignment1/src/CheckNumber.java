/**
 * CheckNumber.java
 * Name: Ali Abdoli
 * Date: February 15, 2018
 *
 *     Purpose: Java program which returns various outputs from its methods depending on num. Explanation of each method is above it.
 *
 * Methods:
 *     checkPos – returns boolean
 *     checkPrime - returns boolean
 *     getDigitNum - returns int
 *     checkPalindrome - returns boolean
 */

public class CheckNumber {
    public int num;

    // Checks if number is above or equal to 0.
    public boolean checkPos() {
        return (num >= 0);
    }

    // Counts 1, 0 and non positive numbers as not prime.
    // Checks if the integer, num, is prime by seeing if it is divisible by any integer from 0 to half of it, using a for loop.
    public boolean checkPrime() {
        if (num == 1 || num == 0 || !checkPos())
            return false;
        for (int i = 2; i <= num/2; i++)
            if (num % i == 0)
                return false;
        return true;
    }

    // Gets the length of the String of the absolute value of the integer, num, after turning it into a string.
    public int getDigitNum() {
        return Integer.toString(Math.abs(num)).length();
    }

    // Checks whether the integer, num, is a palindrome by seeing if the reverse of the String of it, is equal to the non-reversed String of it.
    // A number is called palindrome if number and its reverse is equal.
    public boolean checkPalindrome() {
        return (new StringBuilder(Integer.toString(Math.abs(num))).reverse().toString().equals(Integer.toString(Math.abs(num))));
    }
}
