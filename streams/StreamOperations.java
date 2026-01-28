package streams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamOperations {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> numberResult = numbers.stream()
                .filter(n-> (n%2==0))
                .map(n -> (n*n))
                .collect(Collectors.toList());
        System.out.println(numberResult);
        System.out.println();


        String text = "hello world";
        Map<Character, Long> result = new HashMap<>();
        result = text.chars()
                .filter(c -> c != ' ')
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c->c, Collectors.counting()));

        System.out.println(result);


        List<Integer> numberList = Arrays.asList(3, 7, 2, 9, 1, 5, 8);

        Optional<Integer> max = numberList.stream()
                .max(Integer::compare);
        max.ifPresentOrElse(value -> System.out.println("Max: " + value),()-> System.out.println("Max not found"));

        Optional<Integer> min = numberList.stream()
                .min(Integer::compare);
        min.ifPresentOrElse(value -> System.out.println("Min: " + value), () -> System.out.println("Min not found"));

        Optional<Integer> firstEven = numberList.stream()
                .filter(n -> (n%2==0))
                .findFirst();
        firstEven.ifPresentOrElse(value -> System.out.println("First even: " + value),
                () -> System.out.println("No even number found"));

        Optional<Integer> greaterThan = numberList.stream()
                .filter(n-> n>5)
                .findAny();
        greaterThan.ifPresentOrElse(value -> System.out.println("Any number > 5: " + value),
                () -> System.out.println("No number > 5 found"));

        System.out.println();
        System.out.println();
        System.out.println();




        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);

        int sum = numbers2.stream()
                .reduce(0, (a,b) -> a+b);

        System.out.println("Sum: " + sum);


        int product = numbers.stream()
                .reduce(1, (a,b) -> (a*b));

        System.out.println("Product: " + product);


        Optional<Integer> maxNum = numbers2.stream()
                .reduce((a,b) -> a>b?a:b);
        maxNum.ifPresentOrElse(value -> System.out.println("Max: " + value), () -> System.out.println("Max not found!"));



        System.out.println();
        System.out.println();
        System.out.println();

        List<List<Integer>> nested = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );

        System.out.println(nested);

        List<Integer> flattened = nested.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());
        System.out.println("Flattened: " + flattened);

        List<Integer> evens = flattened.stream()
                .filter(n-> (n%2==0))
                .collect(Collectors.toList());

        System.out.println("Even Numbers: " + evens);





        List<List<String>> nestedWords = Arrays.asList(
                Arrays.asList("one", "two"),
                Arrays.asList("three", "four")
        );

        List<String> flattenedWords = nestedWords.stream()
                .flatMap(list-> list.stream())
                .collect(Collectors.toList());
        System.out.println("Flattened words " + flattenedWords);


    }
}
