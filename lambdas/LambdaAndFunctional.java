package lambdas;

import java.util.*;
import java.util.stream.*;
public class LambdaAndFunctional {
    public static void main(String[] args) {

        //Write a Java 8 program to sort a list of strings by length using lambda.
        List<String> names = Arrays.asList("bob", "alex", "daniel", "xi");
        names.sort((a,b) -> Integer.compare(a.length(), b.length()));
        System.out.println("Sorted by length: " + names);

        //Sort a list of integers in ascending and descending order using lambda.
        List<Integer> numbers = Arrays.asList(2,4,7,9,1,5,8);
        numbers.sort((a,b) -> Integer.compare(a,b));
        System.out.println("Ascending - " + numbers);
        numbers.sort((a,b) -> Integer.compare(b,a));
        System.out.println("Descending - " + numbers);

        //Write a program to filter even numbers from a list using Java 8.
        List<Integer> evenNumber = numbers.stream()
                .filter(n -> (n%2==0))
                .collect(Collectors.toList());
        System.out.println("Even Numbers - " + evenNumber);
        //Find numbers starting with digit 1 using streams.
        List<Integer> nums = Arrays.asList(11,19,35,78,90,43,23,111);
        List<Integer> numsResult = nums.stream()
                .filter(n-> String.valueOf(n).startsWith("1"))
                .collect(Collectors.toList());
        System.out.println("Numbers starting with 1 - " + numsResult);

        //Convert a list of strings to uppercase using Java 8
        List<String> names1 = Arrays.asList("bob", "alex", "daniel", "xi");
        List<String> names2 = names1.stream()
                .map(n-> n.toUpperCase())
                .collect(Collectors.toList());
        System.out.println("UpperCase - " + names2);

        //Write a program to calculate the sum of all elements using streams.
        List<Integer> elements = Arrays.asList(1,2,3,4,5,6,7,8,9);
        int sum = elements.stream()
                .reduce(0,(a,b) -> (a+b));
        System.out.println("Sum - " + sum);


        //Find the maximum and minimum value in a list using Java 8.
        Optional<Integer> max = elements.stream()
                .max(Integer::compare);
        max.ifPresentOrElse(value -> System.out.println("Max Value: " +value), () -> System.out.println("Not Found"));


        //Write a program to check if a list contains duplicate elements using streams.
        List<Integer> input = Arrays.asList(1,4,6,5,4,8);
        boolean isDuplicate = input.stream()
                .distinct()
                .count() != input.size();
        System.out.println("Contains duplicate? " + isDuplicate);


        //Write a program to iterate a list using forEach and lambda.
        List<String> namesList = Arrays.asList("Alex", "Paine", "Max", "Aston");
        namesList.forEach(value -> System.out.print(value + " "));
        System.out.println();

        //Use Predicate to filter strings longer than a given length.
        int limit = 4;
        List<String> greaterLength = namesList.stream()
                .filter(n -> n.length()>limit)
                .collect(Collectors.toList());
        System.out.println("Greater than given length: " + greaterLength);

    }
}
