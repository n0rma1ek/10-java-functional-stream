
package com.example.task04;

import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task04Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(
                System.in, StandardCharsets.UTF_8
        );

        scanner.useDelimiter("[^\\p{L}\\p{N}]+");

        Map<String, Long> frequencies = scanner.tokens()
                .map(word -> word.toLowerCase(Locale.ROOT))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));


        String result = frequencies.entrySet().stream()
                .sorted(
                        Comparator.<Map.Entry<String, Long>>
                                        comparingLong(Map.Entry::getValue)
                                .reversed()
                                .thenComparing(Map.Entry::getKey)
                )
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.joining("\n"));

        System.out.print(result);


    }
}
