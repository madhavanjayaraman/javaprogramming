package com.madhavan.geeksforgeeks;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * author , Madhavan Jayaraman
 * date 6/3/2021 , time 11:40 PM
 * project_name javaprogramming
 * package_name com.madhavan.geeksforgeeks\
 **/
public class SumOfNumbers {

    public static void main(String[] args) {
        System.out.println(sumofNumbersByWhileLoop(999999999));
        System.out.println(sumOfNumbersByArrayAddition(999999999));
    }

    static int sumOfNumbersByArrayAddition(int n){
        int sum = 0;

        String ss = new String(String.valueOf(n));
        char[]  tempArry= ss.toCharArray();

        for(char i : tempArry){
            sum = sum+Character.getNumericValue(i);
        }
        List<char[]> asList = Arrays.asList(tempArry);
       int result = IntStream.range(0, ss.length())
                .map(i -> i + Character.getNumericValue(i))
                .sum();
        return sum;
    }

    static int sumofNumbersByWhileLoop(int n){
        int sum = 0;
        while(n != 0){
            sum = sum+n%10;
            n = n/10;
        }
        return sum;
    }

}
/**
 */