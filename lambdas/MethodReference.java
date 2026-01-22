package lambdas;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MethodReference {
    public static void main(String[] args) {

        System.out.println("_______________________________________________________________________");
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.forEach(System.out::println);
        System.out.println("_______________________________________________________________________");
        System.out.println();



        System.out.println("_______________________________________________________________________");

        String prefix = "J";
        List<String> names2 = Arrays.asList("John", "Alice", "Jane", "Bob", "Jack");
        List<String> names2Result = names2.stream()
                .filter(s -> s.startsWith(prefix))
                .collect(Collectors.toList());
        System.out.println(names2Result);
        System.out.println("_______________________________________________________________________");
        System.out.println();


        System.out.println("_______________________________________________________________________");
        List<String> words = Arrays.asList("HELLO", "WoRLd", "JAVA", "cOdE");
        List<String> wordsLower = words.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        System.out.println(wordsLower);
        System.out.println("_______________________________________________________________________");
        System.out.println();


        System.out.println("_______________________________________________________________________");
        List<ArrayList<Integer>> lists = Stream.generate(()-> new ArrayList<Integer>())
                .limit(5)
                .collect(Collectors.toList());
        System.out.println(lists);
        System.out.println("_______________________________________________________________________");
        System.out.println();


        System.out.println("_______________________________________________________________________");
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9, 3);
        numbers.sort(Integer::compare);
        System.out.println(numbers);
    }
}
