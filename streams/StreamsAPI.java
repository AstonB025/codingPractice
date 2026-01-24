package streams;

import java.util.*;
import java.util.stream.*;

public class StreamsAPI {
    public static void main(String[] args) {

        //Find the first element in a list using streams.
        List<Integer> num = Arrays.asList(4,7,9,2,4,1);
        Optional<Integer> firstNumber = num.stream()
                .findFirst();
        firstNumber.ifPresentOrElse(a -> System.out.println("First Element: " + a), () -> System.out.println("Empty List"));

        //Find the count of elements in a list using streams.
        long count = num.stream()
                .count();
        System.out.println("Number of Elements: " + count);


        //Remove duplicate elements from a list using streams.
        List<Integer> unique = num.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Unique Elements: " + unique);


        //Sort a list using streams.
        List<Integer> sorted = num.stream()
                .sorted((a,b) -> Integer.compare(a,b))
                .collect(Collectors.toList());
        System.out.println("Sorted Elements: " + sorted);


        //Sort a list in reverse order using streams.
        List<Integer> reverseOrder = num.stream()
                .sorted((a,b) -> Integer.compare(b,a))
                .collect(Collectors.toList());
        System.out.println("Sorted Elements in reverse: " + reverseOrder);


        //Find the second highest number in a list using streams.
        Optional<Integer> secondHighest = num.stream()
                .distinct()
                .sorted((a,b) -> Integer.compare(b,a))
                .skip(1)
                .findFirst();
        secondHighest.ifPresentOrElse(n-> System.out.println("Second Highest: " + n), () -> System.out.println("Not Found"));

        //Find the second lowest number in a list using streams.
        Optional<Integer> secondLowest = num.stream()
                .distinct()
                .sorted((a,b) -> Integer.compare(a,b))
                .skip(1)
                .findFirst();
        secondLowest.ifPresentOrElse(n-> System.out.println("Second Lowest: " + n), () -> System.out.println("Not Found"));


        //Find all numbers greater than a given value using streams.
        int check = 5;
        List<Integer> greaterThanCheck = num.stream()
                .filter(n-> n>5)
                .collect(Collectors.toList());
        System.out.println("Element greater than 5: " + greaterThanCheck);


        //Find the average of numbers using streams.
        OptionalDouble avg = num.stream()
                .mapToInt(n->n)
                .average();
        avg.ifPresentOrElse(n-> System.out.println("Average: " + n), () -> System.out.println("Not Found"));

        //Find the sum of squares of even numbers using streams.
        int sumOfSquares = num.stream()
                .filter(n->(n%2==0))
                .map(n->(n*n))
                .reduce(0, (a,b) -> (a+b));
        System.out.println("Sum of Squares: " + sumOfSquares);

    }
}
