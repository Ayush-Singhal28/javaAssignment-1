package edu.knoldus;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Application {

    public static void main(String[] args) throws FileNotFoundException {
        List<Integer> list = IntStream.range(1, 100).filter(x -> isPrimeNumber(x)).boxed().collect(Collectors.toList());
        System.out.println(list);
        List<Integer> list1 = Arrays.asList(5, 2, 6, 4);
        List<Integer> list2 = Arrays.asList(15, 12, 16, 14);
        multiplyTwoList(list1, list2);
        File file = new File("/home/knoldus/JavaAssignment1/ContentFile.txt");
        readingContentOfFile(file);
    }

    private static boolean isPrimeNumber(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public static void multiplyTwoList(List<Integer> list1, List<Integer> list2) {
        List<Integer> multiply = IntStream.range(0, list1.size()).map(x -> (list1.get(x) * list2.get(x))).boxed().collect(Collectors.toList());
        System.out.println(multiply);
    }

    public static void readingContentOfFile(File file) throws FileNotFoundException {
        Hashtable<String, Integer> readingCount = new Hashtable<>();
        Integer occur;
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] word = line.split(" ");
            for (String s : word) {
                occur = readingCount.get(s);
                if (occur == null) {
                    readingCount.put(s, 1);
                } else {
                    readingCount.put(s, occur + 1);
                }
            }
        }
        System.out.println(readingCount);

    }
}
