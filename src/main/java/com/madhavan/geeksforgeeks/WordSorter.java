package com.madhavan.geeksforgeeks;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * author Madhavan Jayaraman
 * date 6/16/2021 , time 5:16 PM
 * project_name javaprogramming
 * package_name com.madhavan.geeksforgeeks\
 **/
public class WordSorter {
    public static void main(String[] args) {
        measureTime("BufferedReader.readLine() into ArrayList", WordSorter::bufferReaderToArrayList, args[0]);
    }

    private static void measureTime(String name, Function<String, List<String>> fn, String path) {
        System.out.println("-----------------------------------------------------------");
        System.out.println("run: " + name);
        long startTime = System.nanoTime();
        try {
            fn.apply(path).stream().map(w -> w.split("\\s+")).flatMap(Arrays::stream)
                    .filter(o -> !o.isEmpty())
                    .map(String::toLowerCase)
                    .sorted()
                    .collect(Collectors.collectingAndThen(Collectors.toList(), Optional::of))
                    .filter(s -> !s.isEmpty()).orElseThrow(() -> new Exception("Usage: WordSorter file"))
                    .forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Usage: WordSorter file");
        }

        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("estimatedTime: " + NANOSECONDS.toMillis(estimatedTime)+"ms");
    }

/*    private static List<String> getWordList(List<String> line){
        return line.stream().forEach(o -> o.);
    }*/

    private static List<String> bufferReaderToArrayList(String path) {
        return bufferReaderToList(path, new ArrayList<>());
    }

    private static List<String> bufferReaderToList(String path, List<String> list) {
        try {
            final BufferedReader in = new BufferedReader(
                    new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
            String line;
            while ((line = in.readLine()) != null) {
                list.add(line);
            }
            in.close();
        } catch (final IOException e) {
            System.out.println("Invalid File: "+ Paths.get(path).getFileName());
        }
        return list;
    }

}
