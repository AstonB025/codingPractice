package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReferenceJava {

    public static void main(String[] args) {
        System.out.println("_____________________________________________________________________");

        List<Integer> numbs = Arrays.asList(-5, 3, -2, 7, -1);

        List<Integer> numbResult = numbs.stream()
                .map(Math::abs)
                .collect(Collectors.toList());

        System.out.println(numbResult);

        System.out.println("_____________________________________________________________________");


        // You have a specific number to compare against
        Integer threshold = 5;

        // Filter numbers greater than threshold using threshold::compareTo
        List<Integer> nums = Arrays.asList(1, 6, 3, 8, 2, 9);

        List<Integer> numsRes = nums.stream()
                    .filter(n -> threshold.compareTo(n) < 0)
                .collect(Collectors.toList());

        System.out.println(numsRes);

        System.out.println("_____________________________________________________________________");


        // You have a list of strings
        List<String> wordList = Arrays.asList("  hello  ", "  world  ", "  java  ");

        // Trim all strings using String::trim
        // Expected output: [hello, world, java]

        List<String> wordListRes = wordList.stream()
                .map(String::trim)
                .collect(Collectors.toList());

        System.out.println(wordListRes);

        System.out.println("_____________________________________________________________________");

        // You have a list of numbers as strings
        List<String> stringNumbers = Arrays.asList("10", "20", "30");

        // Convert to Integer objects using Integer::new
        // Expected output: [10, 20, 30] (as Integer objects)


        List<Integer> stringToInt = stringNumbers.stream()
                .map(Integer::new)
                .collect(Collectors.toList());

        System.out.println(stringToInt);

        System.out.println("_____________________________________________________________________");

    }
}
