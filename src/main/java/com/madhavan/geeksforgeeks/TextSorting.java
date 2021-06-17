package com.madhavan.geeksforgeeks;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
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
        try {
            Files.lines(Paths.get(args[0]))
                    .flatMap(Pattern.compile("\\s+")::splitAsStream)
                    .filter(o -> !o.isEmpty())
                    .map(String::toLowerCase)
                    .sorted()
                    .collect(Collectors.collectingAndThen(Collectors.toList(), Optional::of))
                    .filter(s -> !s.isEmpty()).orElseThrow(() -> new Exception("Usage: WordSorter file"))
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Invalid File: " + args[0]);
        } catch (Exception e) {
            System.err.println("Usage: WordSorter file");
        }
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
