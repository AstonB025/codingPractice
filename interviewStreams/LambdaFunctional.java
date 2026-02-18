package interviewStreams;


import java.util.*;
import java.util.List;
import java.util.stream.*;
import java.util.function.*;

@FunctionalInterface
interface Operation {
    int ops(int a, int b);
}

class LambdaFunctional {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("Hi", "Hello", "Java", "Coding");
        List<Integer> numbers = Arrays.asList(2,4,7,9,6,1,3,0,8,5);
        List<Integer> nums = Arrays.asList(11,16,89,07,54,36,23,21,15,54);

        //1. Write a Java 8 program to sort a list of strings by length using lambda
        List<String> wordsLength = words.stream()
                .sorted((a,b) -> Integer.compare(a.length(),b.length()))
                .collect(Collectors.toList());
        System.out.println("Words sorted by length: " + wordsLength);



        // 2. Sort a list of integers in ascending and descending order using lambda.
        List<Integer> numbersAsc = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        List<Integer> numbersDsc = numbers.stream()
                .sorted((a,b) -> Integer.compare(b,a))
                .collect(Collectors.toList());
        System.out.println("Sorted in Ascending Order: " + numbersAsc);
        System.out.println("Sorted in Descending Order: " + numbersDsc);


        // 3. Write a program to filter even numbers from a list using Java 8.
        List<Integer> numbersEven = numbers.stream()
                .filter(n -> (n%2==0))
                .collect(Collectors.toList());
        System.out.println("Even numbers: " + numbersEven);



        // 4. Find numbers starting with digit 1 using streams.
        List<String> numsWith1 = nums.stream()
                .map(String::valueOf)
                .filter(n -> n.startsWith("1"))
                .collect(Collectors.toList());
        System.out.println("Numbers starting with 1: " + numsWith1);


        // 5.Convert a list of strings to uppercase using Java 8.
        List<String> wordsUpper = words.stream()
                .map(n -> n.toUpperCase())
                .collect(Collectors.toList());
        System.out.println("Words in upper case: " + wordsUpper);

        // 6. Write a program to calculate the sum of all elements using streams.
        int sum = nums.stream()
                .reduce(0, (a,b) -> (a+b));
        System.out.println("Sum of the nums: " + sum );


        // 7. Find the maximum and minimum value in a list using Java 8.
        Optional<Integer> numsMax = nums.stream()
                .max((a,b) -> a.compareTo(b));
        Optional<Integer> numsMin = nums.stream()
                .min(Integer::compareTo);
        numsMax.ifPresentOrElse(value -> System.out.println("Max Value: " + value), () -> System.out.println("Not found"));
        numsMin.ifPresentOrElse(value -> System.out.println("Min Value: " + value), () -> System.out.println("Not found"));


        // All in one pass
        IntSummaryStatistics stats = nums.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();
        System.out.println("Max Value: " + stats.getMax());
        System.out.println("Min Value: " + stats.getMin());


        // 8. Write a program to check if a list contains duplicate elements using streams.
        boolean hasDuplicates = nums.stream()
                .distinct()
                .count() != nums.size();
        System.out.println("Contains Duplicate?: " + hasDuplicates);

        // 9. Write a program to iterate a list using forEach and lambda.
        nums.forEach(n -> System.out.print(n + " "));
        System.out.println();

        // 10. Use Predicate to filter strings longer than a given length.
        int length = 4;
        List<String> wordsFilter = words.stream()
                .filter( n -> (n.length() > length))
                .collect(Collectors.toList());
        System.out.println("Words greater than given length: " + wordsFilter);


        // 11. Create a custom functional interface with @FunctionalInterface annotation and use it with lambda.
        Operation op = (a, b) -> (a+b);
        System.out.println(op.ops(5,4));


        // 12. Use Function<T, R> to convert a list of integers to their squares.
        Function<Integer, Integer>  squareFunction = value -> (value*value);
        List<Integer> squaresNums = nums.stream()
                .map(squareFunction)
                .collect(Collectors.toList());
        System.out.println("Squares of nums using the function: " + squaresNums);

        // 13. Use Consumer<T> to print each element with a custom prefix.
        Consumer<String> printConsumer = value -> System.out.print(value + " ");
        words.forEach(printConsumer);
        System.out.println();

        // 14. Use Supplier<T> to generate random numbers and collect them.
        Supplier<Integer> randomSupply =  () -> (int) (Math.random() * 100);
        List<Integer> randomNumbers = Stream
                .generate(randomSupply)
                .limit(10)
                .collect(Collectors.toList());
        System.out.println("Random Numbers: " + randomNumbers);


        // 15. Chain multiple Predicates using and(), or(), negate() to filter a list.
        Predicate<Integer> evenNum = n -> (n%2==0);
        Predicate<Integer> greaterThan = n -> (n>5);
        Predicate<Integer> lessThan12 = n -> n < 12;

        List<Integer> numbersResult = numbers.stream()
                .filter(evenNum.and(greaterThan).or(lessThan12.negate()))
                .collect(Collectors.toList());
        System.out.println("Chaining Multiple Predicates: " + numbersResult);
































    }
}