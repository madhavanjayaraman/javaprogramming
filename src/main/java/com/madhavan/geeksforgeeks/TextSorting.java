package com.madhavan.geeksforgeeks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * author e3016939, Madhavan Jayaraman
 * date 6/15/2021 , time 7:16 PM
 * project_name javaprogramming
 * package_name com.madhavan.geeksforgeeks\
 **/
public class TextSorting {

    public static void main(String[] args) {


        try {

          Files.lines(Paths.get(args[0]))
                    .flatMap(Pattern.compile("\\s+")::splitAsStream)
                    .sorted()
                    .collect(Collectors.toList())
                  .stream().filter(s-> !s.isEmpty())
                  .forEach(System.out::println);
            //stream.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Invalid File: "+args[0]);
        }

    }


    /****
     *
     /*
     StringBuilder sb = new StringBuilder();

     try (BufferedReader br = Files.newBufferedReader(Paths.get(args[0]))) {

     // read line by line
     String line;
     while ((line = br.readLine()) != null) {
     sb.append(line).append("\n");
     String[] words = line.split(" ");


     *//* Reader reader = new StringReader(s);
                Stream<List<String>> stream = records(StreamEx.ofLines(reader)
                        .flatMap(Pattern.compile("\\s+")::splitAsStream));
                stream.forEach(System.out::println);*//*
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        System.out.println(sb);*/
}
