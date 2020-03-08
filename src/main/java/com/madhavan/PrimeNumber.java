package com.madhavan;

import java.util.Scanner;

/**
 * author, Madhavan Jayaraman
 * date 3/8/2020 , time 4:18 PM
 * project_name javaprogramming
 * package_name com.madhavan\
 **/

/***
 * What is prime number?
 *
 *
 * A number is considered as prime number when it satisfies the below conditions.
 *
 * It should be whole number
 * It should be greated than 1
 * It should have only 2 factors. They are, 1 and the number itself.
 * Example for prime numbers: 2, 3, 5, 7, 11, 13, 17, 19, 23 etc.
 *
 * Why 4, 6, 8, 9, 10, 12, 14, 15, 16 etc are not prime numbers?
 *
 * Because, the number 4 can be factored as 2*2 and 1*4.
 * As per the rule of prime number, there should be 2 factors only.
 * They are 1 and the number itself. But, number 4 has 2*2 also.
 * Like this, all remaining numbers 6, 8, 9, 10, 12, 14, 15, 16 have factors other than 1 and the number itself.
 * So, these are not called as prime numbers.
 */
public class PrimeNumber {
    public static void main(String[] args) {

        // Input number to find whether the given number is prime or not
        System.out.println("Input number to find whether the given number is prime or not");
        isInputPrimeOrNot();
    }

    /**
     * Simple Prime Number
     ****/

    private static boolean isInputPrimeOrNot() {
        int i, num = 0, p = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 0 to exit, or ");
        System.out.print("Enter number to find prime or not=");
        String getNumber = scanner.next();
        num = Integer.valueOf(getNumber);
        if (num == 0) return true;
        for (i = 1; i <= num; i++) {
            if (num % i == 0) {
                p++;
            }
        }
        if (p == 2) {
            System.out.println("Entered number is " + num + " and it is a prime number.");
            isInputPrimeOrNot();
        } else {
            System.out.println("Entered number is " + num + " and it is not a prime number.");
            isInputPrimeOrNot();
        }
        return true;

    }
}
