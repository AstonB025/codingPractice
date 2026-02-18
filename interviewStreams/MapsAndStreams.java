package interviewStreams;

import java.util.*;
import java.util.stream.*;

class Employee {
    int id;
    String name;
    String department;

    Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
public class MapsAndStreams {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,5,7,4,5,6,3,2,9,8,6,1,7,3);
        List<String> words = Arrays.asList("Hi", "Hello", "Java", "Coding", "Java", "Coding", "Programming", "Software", "AI", "SpringBoot");

        //1. Find the sum of all numbers using reduce().
        int sumOfNumbers = numbers.stream()
                .reduce(0, (a,b) -> (a+b));
        System.out.println("Sum of the numbers using reduce: " + sumOfNumbers);

        //2. Find the product of all numbers using reduce().
        int productOfNumbers = numbers.stream()
                .reduce(1, (a,b) -> (a*b));
        System.out.println("Product of the numbers using reduce: " + productOfNumbers);

        //3. Find the longest string in a list using reduce().
        Optional<String> longestWord = words.stream()
                .reduce((s1, s2) -> s1.length() >= s2.length() ? s1 : s2);
        longestWord.ifPresentOrElse(value -> System.out.println("Longest word: " + value), () -> System.out.println("Not found"));


        //4. Convert a list into a set using collect().
        Set<Integer> setOfNumbers = numbers.stream()
                .collect(Collectors.toSet());
        System.out.println("Set of numbers: " + setOfNumbers);


        //5. Convert a list into a map using streams.
            /*Collectors.toMap() fails when there are duplicate keys, unless
            a merge function is provided*/
        Map<String, Integer> wordsLength = words.stream()
                .collect(Collectors.toMap(
                        word -> word,
                        word -> word.length(),
                        (existing, replacement) -> existing)); // merge function
        System.out.println("Words by length: " + wordsLength);


        //6. Group strings by their length using groupingBy().
        /*
        Collectors.groupingBy() always returns a Map.
        Example Output - 2=[Hi, AI]
          So, the key here is the number and the values are in a list of words*/
        Map<Integer, List<String>> groupedByLength = words.stream()
                .collect(Collectors.groupingBy(word -> word.length()));
        // or .collect(Collectors.groupingBy(String::length));
        System.out.println("Words grouped by length: " + groupedByLength);


        //7. Group employees by department using streams.
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "IT"),
                new Employee(2, "Bob", "HR"),
                new Employee(3, "Charlie", "IT"),
                new Employee(4, "David", "Finance"),
                new Employee(5, "Eve", "HR")
        );
        Map<String, List<Employee>> employeesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(name -> name.getDepartment()));
        // System.out.println("Employees grouped by department: " + employeesByDepartment);

        /*employeesByDept.forEach((dept, empList) -> {
    System.out.println(dept + " -> ");
    empList.forEach(e -> System.out.println("   " + e.getName()));
});
*/
        employeesByDepartment.forEach((dept, empList) -> {
            System.out.println(dept + " -> ");
            empList.forEach(e -> System.out.println("   " + e.getName()));
        });


        //8. Count occurrences of each word in a list using streams.
        Map<String, Long> wordOccurence = words.stream()
                .collect(Collectors.groupingBy( word -> word,
                        Collectors.counting()));
        System.out.println("Occurences of each word: " + wordOccurence);


        //9. Partition numbers into even and odd using streams.
        Map<Boolean, List<Integer>> evenAndOdd = numbers.stream()
                .collect(Collectors.partitioningBy( n -> (n%2==0)));
        System.out.println("Even Numbers: " + evenAndOdd.get(true));
        System.out.println("Odd Numbers: " + evenAndOdd.get(false));



        //10. Join a list of strings with a delimiter using joining().
        String joinedWords = words.stream()
                .collect(Collectors.joining(" , "));
        System.out.println("Words joined using delimitter: " + joinedWords);


        //11. **Count character occurrences in a string that occur more than once using `Collectors.groupingBy()` and `Collectors.counting()`.** *(You fumbled this)*
        String inputWord = "hihowareyouhello";
        Map<Character, Long> charCount = inputWord.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        c->c,
                        Collectors.counting()));
        System.out.println("Characters count in a word: " + charCount);



        //12. Use `Collectors.toMap()` with merge function to handle duplicate keys
        Map<String, Integer> mergeFunction = words.stream()
                .collect(Collectors.toMap( c -> c,
                        c -> c.length(),
                        (existing, replacement)-> replacement));
        System.out.println("Using Merge Function: " + mergeFunction);


        //13. Find the sum of values in a Map using streams.
        /*.mapToInt(n -> n) converts Integer → int because .sum() works on IntStream*/
        int sumNum = numbers.stream()
                .mapToInt(n -> n)
                .sum();
        System.out.println("Sum of numbers: " + sumNum);


        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 85);
        scores.put("Bob", 90);
        scores.put("Charlie", 78);

        int sumOfScores = scores.values().stream()
                .mapToInt( n -> n) // or  .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum of Scores in a map: " + sumOfScores);


        //14. Use `Collectors.summarizingInt()` to get count, sum, min, max, average in one go.
        IntSummaryStatistics stats = numbers.stream()
                .collect(Collectors.summarizingInt(n -> n));
        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Max: " + stats.getMax());
        System.out.println("Average: " + stats.getAverage());


        //15. Create a custom Collector to build a comma-separated string.
            /*A custom collector in Java requires 3 main parts:
            Supplier → creates a new container (StringBuilder here)
            Accumulator → adds an element to the container
            Combiner → merges two containers (needed for parallel streams)
            Finisher → converts the container into the final result (String)
            */

        String result = words.stream()
                .collect(
                        Collector.of(
                                StringBuilder::new,                // Supplier: create a StringBuilder
                                (sb, s) -> {                       // Accumulator: append word + comma
                                    if(sb.length() > 0) sb.append(",");
                                    sb.append(s);
                                },
                                (sb1, sb2) -> {                    // Combiner: merge two StringBuilders
                                    if(sb1.length() > 0 && sb2.length() > 0) sb1.append(",");
                                    sb1.append(sb2);
                                    return sb1;
                                },
                                StringBuilder::toString             // Finisher: convert to String
                        )
                );

        System.out.println("Comma-separated string: " + result);
    }
}
