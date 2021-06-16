package com.madhavan.geeksforgeeks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * author e3016939, Madhavan Jayaraman
 * date 6/15/2021 , time 7:16 PM
 * project_name javaprogramming
 * package_name com.madhavan.geeksforgeeks\
 **/
public class TextSorting {

    public static void main(String[] args) {

        // get the start time
        long start = System.nanoTime();

        try {
            Files.lines(Paths.get(args[0]))
                    .flatMap(Pattern.compile("\\s+")::splitAsStream)
                    .filter(o -> !o.isEmpty())
                    .map(String::toLowerCase)
                    .sorted()
                    .collect(Collectors.collectingAndThen(Collectors.toList(), Optional::of))
                    .filter(s -> !s.isEmpty()).orElseThrow(() -> new Exception("Usage: WordSorter file"))
                    .forEach(System.out::println);

/*          Files.lines(Paths.get(args[0]))
                    .flatMap(Pattern.compile("\\s+")::splitAsStream)
                    .sorted()
                    .collect(Collectors.collectingAndThen(Collectors.toList(), Optional::of))
                  .filter(s-> !s.isEmpty()).orElseThrow(() -> new Exception("Usage: WordSorter file"))
                  .forEach(System.out::println);*/
            //stream.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Invalid File: " + args[0]);
        } catch (Exception e) {
            System.err.println("Usage: WordSorter file");
        }
        // get the end time
        long end = System.nanoTime();

        // execution time in seconds
        long execution = (end - start);
        System.out.println("Execution time of Sorting is");
        System.out.println((double)execution / 1_000_000_000.0 + " seconds");
        System.out.println(NANOSECONDS.toMillis(execution) + " ms");
        //NANOSECONDS.toMillis(execution);
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
