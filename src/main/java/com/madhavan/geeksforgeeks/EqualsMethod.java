package com.madhavan.geeksforgeeks;

import java.util.HashSet;
import java.util.Set;

/**
 * author e3016939, Madhavan Jayaraman
 * date 6/10/2021 , time 5:07 PM
 * project_name javaprogramming
 * package_name com.madhavan.geeksforgeeks\
 **/
public class EqualsMethod {

    public static void main(String[] args) {
        method1();
    }

    private static void method1(){
        Set<String> arraySet1 = new HashSet<>();

        // Populating arrset1
        arraySet1.add("US31620M1061");
        arraySet1.add("US31620M1062");
        arraySet1.add("DE31620M1064");
        arraySet1.add("IN31620M1065");
        arraySet1.add("AM31620M1063");
        arraySet1.add("AA31620M1062");
        arraySet1.add("AA31620M1062");

        // print arrset
        System.out.println(arraySet1);

        Set<String> arraySet2 = new HashSet<>();

        //Population array set 2

        arraySet2.add("US31620M1061");
        arraySet2.add("US31620M1062");
        arraySet2.add("DE31620M1064");
        arraySet2.add("IN31620M1065");
        arraySet2.add("AM31620M1063");
        arraySet2.add("AA31620M1062");

        System.out.println(arraySet2);


        System.out.println(arraySet1.equals(arraySet2));

    }
}
