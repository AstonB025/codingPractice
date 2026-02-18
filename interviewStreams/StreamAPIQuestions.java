package interviewStreams;

import java.util.*;
import java.util.List;
import java.util.stream.*;
import java.util.function.*;


public class StreamAPIQuestions {
    public static void main(String[] args) {


        List<String> words = Arrays.asList("Hi", "Hello", "Java", "Coding");
        List<String> repeatedWords = Arrays.asList("Hi", "Hello", "Java", "Coding", "Java", "Java", "Coding");
        List<Integer> numbers = Arrays.asList(2,4,7,9,6,1,3,0,8,5);
        List<Integer> nums = Arrays.asList(11,16,89,07,54,36,23,21,15,54);
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );

        // 1. Find the first element in a list using streams.
        List<String> firstWord = words.stream()
                .limit(1)
                .collect(Collectors.toList());
        System.out.println("First word in the list: " + firstWord);

        //can be done using Optional<> as well
        Optional<String> firstElement = words.stream()
                .findFirst();
        firstElement.ifPresentOrElse(value -> System.out.println("First Element is: " + value) , () -> System.out.println("Not Found"));

        // 2. Find the count of elements in a list using streams.
        long totalElements = words.stream()
                .count();
        System.out.println("Total number of Words: " + totalElements);

        // 3. Remove duplicate elements from a list using streams.
        Set<Integer> uniqueNums = nums.stream()
                .distinct()
                .collect(Collectors.toSet());
        System.out.println("Unique elements from the list: " + uniqueNums);

        // 4. Sort a list using streams.
        List<String> sortedWords = words.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println("Sorted words by length: " + sortedWords);


        // 5. Sort a list in reverse order using streams.
        List<String> reverseSortedWords = words.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .collect(Collectors.toList());
        System.out.println("Sorted words by length: " + reverseSortedWords);


        // 6. Find the second highest number in a list using streams.
        List<Integer> secondHighest = nums.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .limit(1)
                .collect(Collectors.toList());
        System.out.println("Second Highest Element: " + secondHighest);

        // can be done with Optional<> as well
        Optional<Integer> secondLargest = nums.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
        secondLargest.ifPresentOrElse( n -> System.out.println("Second largest element: " + n) , () -> System.out.println("Not Found"));


        // 7. Find the second lowest number in a list using streams.
        Optional<Integer> secondLowest = nums.stream()
                .sorted()
                .skip(1)
                .findFirst();
        secondLowest.ifPresentOrElse( n -> System.out.println("Second lowest element: " + n), () -> System.out.println("Not found"));

        // can be done without sorting (for large list)
        int min = nums.stream()
                .min(Integer::compareTo)
                .get();
        Optional<Integer> secondMin = nums.stream()
                .filter(n -> n != min)
                .min(Integer::compareTo);
        secondMin.ifPresentOrElse( n -> System.out.println("Second Min element: " + n), () -> System.out.println("Not found"));

        // 8. Find all numbers greater than a given value using streams.
        int given = 55;
        List<Integer> greaterThanGiven = nums.stream()
                .filter( n -> (n>given))
                .collect(Collectors.toList());
        System.out.println("Numbers greater than given: " + greaterThanGiven);

        // 9. Find the average of numbers using streams.
        OptionalDouble avg = nums.stream()
                .mapToInt(Integer::intValue)
                .average();
        avg.ifPresentOrElse(n -> System.out.println("Average: " + n), () -> System.out.println("Not Found"));

        // 10. Find the sum of squares of even numbers using streams.
        int sumOfSquare = nums.stream()
                .filter( n -> (n%2==0))
                .map( n -> (n*n))
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("sum of squares of even numbers: " + sumOfSquare);


        // Or can be done using .reduce()
        int sumOfS = nums.stream()
                .filter( n -> (n%2==0))
                .map( n -> (n*n))
                .reduce(0, Integer::sum);
        System.out.println("sum of squares of even numbers using .reduce(): " + sumOfSquare);

        // 11. Find the second largest number WITHOUT using sorted() (optimize for large lists).
        int maximum = nums.stream()
                .max(Integer::compareTo)
                .get();
        Optional<Integer> secLar = nums.stream()
                .filter( n -> n!= maximum)
                .max(Integer::compareTo);
        secLar.ifPresentOrElse( n -> System.out.println("Second Largest without sorting: " + n), () -> System.out.println("Not Found"));

        // 12. Flatten a list of lists using flatMap().
        List<Integer> flattenedList =   listOfLists.stream()
                .flatMap(List::stream)  // converts each inner list into a stream
                .collect(Collectors.toList());
        System.out.println("Flattened List: " + flattenedList);

        // 13. Use limit() and skip() to paginate through a list.
        int pageNumber = 2;
        int pageSize = 3;
        List<Integer> page = numbers.stream()
                .skip((pageNumber-1)*pageSize) //skip previous pages
                .limit(pageSize) //  // take pageSize elements
                .collect(Collectors.toList());
        System.out.println("Page " + pageNumber + ": " + page);


        // 14. Find elements that appear more than once in a list. (You fumbled this).
        Map<String, Long> wordsDuplicate = repeatedWords.stream()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()));
        System.out.println(wordsDuplicate);

        // If you only want to display the words appearing more than 1

        List<String> wordsMoreThan1 =  repeatedWords.stream()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1) // more than once
                .map(Map.Entry::getKey) .collect(Collectors.toList());
        System.out.println("Words appearing more than once: " + wordsMoreThan1);

        // Using Set
        List<Integer> duplicatesNums = nums.stream()
                .filter(n -> Collections.frequency(nums, n) > 1)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(duplicatesNums);

        // Using set and while streaming
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = nums.stream()
                .filter(n -> !seen.add(n))
                .collect(Collectors.toSet());
        System.out.println(duplicates);



        // 15. Use takeWhile() and dropWhile() (Java 9+) to process elements conditionally.

        /*
        Key idea (VERY IMPORTANT)
        These work on ORDER, not on the whole list.
        takeWhile() → take elements UNTIL condition becomes false
        dropWhile() → drop elements UNTIL condition becomes false
        Once the condition fails, they STOP checking further elements.
        */

        List<Integer> elements = Arrays.asList(2, 4, 6, 8, 1, 10, 12);

        // takeWhile()
        List<Integer> resultTakeWhile = elements.stream()
                .takeWhile(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(resultTakeWhile);

        //dropWhile()
        List<Integer> resultDropWhile = elements.stream()
                .dropWhile(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(resultDropWhile);


    }
}
