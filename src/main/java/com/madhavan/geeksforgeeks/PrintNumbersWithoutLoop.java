package com.madhavan.geeksforgeeks;

/**
 * author Madhavan Jayaraman
 * date 6/3/2021 , time 4:47 PM
 * project_name javaprogramming
 * package_name com.madhavan.geeksforgeeks\
 **/
public class PrintNumbersWithoutLoop {

    //Method 1
    static  void usingRecursion1(int n){
        if(n <= 100){
            System.out.println(n);
            usingRecursion1(n+1);
        }
        return;
    }

    // Method 2
    //print numbers from 1 - 100 - Reverse way
    static void usingRecursion2(int n){
        if(n > 0) {
            usingRecursion2(n - 1);
            System.out.println(n);
        }
        return;
    }

    public static void main(String[] args) {
        //usingRecursion1(100);
        usingRecursion2(1);

        /**
         * System.out.println("1st way to print 1 to 100 without loops");
         * usingSysOut();
         *
         * System.out.println("2nd way to print 1 to 100 without using loops");
         * usingSysPrint();
         *
         * System.out.println("3rd way to print 1 to 100 without loops");
         * usingRecursion(10);
         *
         */
    }
}

/**
 * If we take a look at this problem carefully,
 * we can see that the idea of “loop” is to track some counter value e.g. “i=0” till “i <= 100”.
 * So if we aren’t allowed to use loop, how else can be track something in C language!
 * Well, one possibility is the use of ‘recursion’ provided we use the terminating condition carefully.
 * Here is a solution that prints numbers using recursion.
 *
 * Time Complexity : O(n)
 * Now try writing a program that does the same but without any “if” construct.
 * Hint — use some operator which can be used instead of “if”.
 * Please note that recursion technique is good but every call to the function creates one “stack-frame” in program stack.
 * So if there’s constraint to the limited memory and we need to print large set of numbers, “recursion” might not be a good idea.
 * So what could be the other alternative?
 * Another alternative is “goto” statement.
 * Though use of “goto” is not suggestible as a general programming practice as “goto” statement changes the normal program execution sequence yet in some cases, use of “goto” is the best working solution.
 * So please give a try printing numbers from 1 to 100 with “goto” statement
 */
