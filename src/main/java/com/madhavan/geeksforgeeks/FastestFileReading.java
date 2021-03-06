package com.madhavan.geeksforgeeks;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * author e3016939, Madhavan Jayaraman
 * date 6/16/2021 , time 5:05 PM
 * project_name javaprogramming
 * package_name com.madhavan.geeksforgeeks\
 **/
public class FastestFileReading {

    public static void main(String[] args) {
        String path = args[0];
        measureTime("BufferedReader.readLine() into LinkedList", FastestFileReading::bufferReaderToLinkedList, path);
        measureTime("BufferedReader.readLine() into ArrayList", FastestFileReading::bufferReaderToArrayList, path);
        measureTime("Files.readAllLines()", FastestFileReading::readAllLines, path);
        measureTime("Scanner.nextLine() into ArrayList", FastestFileReading::scannerArrayList, path);
        measureTime("Scanner.nextLine() into LinkedList", FastestFileReading::scannerLinkedList, path);
        measureTime("RandomAccessFile.readLine() into ArrayList", FastestFileReading::randomAccessFileArrayList, path);
        measureTime("RandomAccessFile.readLine() into LinkedList", FastestFileReading::randomAccessFileLinkedList, path);
        System.out.println("-----------------------------------------------------------");

    }

    private static void measureTime(String name, Function<String, List<String>> fn, String path) {
        System.out.println("-----------------------------------------------------------");
        System.out.println("run: " + name);
        long startTime = System.nanoTime();
        List<String> l = fn.apply(path);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("lines: " + l.size());
        System.out.println("estimatedTime: " + NANOSECONDS.toMillis(estimatedTime)+"ms");
    }

    private static List<String> bufferReaderToLinkedList(String path) {
        return bufferReaderToList(path, new LinkedList<>());
    }

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
            e.printStackTrace();
        }
        return list;
    }

    private static List<String> readAllLines(String path) {
        try {
            return Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static List<String> randomAccessFileLinkedList(String path) {
        return randomAccessFile(path, new LinkedList<>());
    }

    private static List<String> randomAccessFileArrayList(String path) {
        return randomAccessFile(path, new ArrayList<>());
    }

    private static List<String> randomAccessFile(String path, List<String> list) {
        try {
            RandomAccessFile file = new RandomAccessFile(path, "r");
            String str;
            while ((str = file.readLine()) != null) {
                list.add(str);
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static List<String> scannerLinkedList(String path) {
        return scanner(path, new LinkedList<>());
    }

    private static List<String> scannerArrayList(String path) {
        return scanner(path, new ArrayList<>());
    }

    private static List<String> scanner(String path, List<String> list) {
        try {
            Scanner scanner = new Scanner(new File(path));
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
