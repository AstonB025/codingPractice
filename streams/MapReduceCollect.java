package streams;

import java.util.*;
import java.util.stream.*;
public class MapReduceCollect {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,4,7,9,3,6,8);
        List<String>  listString = Arrays.asList("Bob", "Xi", "Tuttu", "Aston", "Hannah");


        //Find the sum of all numbers using reduce().
        int sum = list.stream()
                .reduce(0, (a,b) -> (a+b));
        System.out.println("Sum using reduce: " + sum);

        //Find the product of all numbers using reduce().
        int product = list.stream()
                .reduce(1, (a,b) -> (a*b));
        System.out.println("Product using reduce: " + product);

        //Find the longest string in a list using reduce().
        String longestString = listString.stream()
                .reduce((a,b)->(a.length() >= b.length() ? a:b))
                .orElse("");
        System.out.println("Longest String: " + longestString);


        //Convert a list into a set using collect().
        Set<Integer> setInteger = list.stream()
                .collect(Collectors.toSet());
        System.out.println("List into Set: " + setInteger);


        //Convert a list into a map using streams.
        Map<String, Integer> mapStrInt = listString.stream()
                .collect(Collectors.toMap(n->n, n->n.length()));
        System.out.println("List into Map with value and Length: " + mapStrInt);


        //Group strings by their length using groupingBy().
        Map<Integer, List<String>> mapGroup = listString.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("Grouping Strings by their lengths: " + mapGroup);


        //Group employees by department using streams.
    /*class Employee {
    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }
}
List<Employee> employees = Arrays.asList(
        new Employee("Alice", "IT"),
        new Employee("Bob", "HR"),
        new Employee("Charlie", "IT"),
        new Employee("David", "HR"),
        new Employee("Eva", "Finance")
);

Map<String, List<Employee>> employeeByDept = employees.stream()
                                                        .collect(Collectors.groupingBy(Employee::getDepartment));
*/


        //Count occurrences of each word in a list using streams.
        List<String> words = Arrays.asList(
                "apple", "banana", "apple", "kiwi", "banana", "apple"
        );

        Map<String, Long> wordCount = words.stream()
                .collect(Collectors.groupingBy(n->n, Collectors.counting()));
        wordCount.forEach((word, count) ->
                System.out.println(word + " occurs " + count + " times"));



        //Partition numbers into even and odd using streams.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Even numbers: " + partitioned.get(true));
        System.out.println("Odd numbers: " + partitioned.get(false));


        //Join a list of strings with a delimiter using joining().
        String result = words.stream()
                .collect(Collectors.joining("| "));
        System.out.println("String join with delimitter: " + result);

    }
}
