package com.madhavan.geeksforgeeks;

/**
 * author Madhavan Jayaraman
 * date 6/3/2021 , time 4:03 PM
 * project_name javaprogramming
 * package_name com.madhavan.geeksforgeeks\
 **/

/**
 * Return maximum occurring character in an input string
 */
public class MaximumOccurence {
    /*
    Write an efficient function to return maximum occurring character in the input string
    e.g., if input string is “test” then function should return ‘t’.
     */

    static final int ASCII_SIZE = 256;

    static char getMaxOccuring(String str){
        char result = ' ';

        int count[] = new int[ASCII_SIZE];

        int len = str.length();

        for(int i=0; i<len;i++) count[str.charAt(i)]++;

        int max = -1;
        for(int i=0;i<len;i++) {
            if(max < count[str.charAt(i)]) {
                max = count[str.charAt(i)];
                result = str.charAt(i);
            }
        }



        return result;
    }

    public static void main(String[] args) {
        final String inputStr = "This is a random check am Madhavan";
        System.out.println(getMaxOccuring(inputStr));
    }
}
