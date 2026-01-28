package streams;

import java.util.*;
import java.util.stream.Collectors;

public class HCLSolutions {
    public static void main(String[] args) {

        /*
        * 1. Given a list of Integers, find the second highest element using streams
        * */

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        List<Integer> result = numbers.stream()
                .distinct()  // optional in case if there are some same elements
                .sorted(Comparator.reverseOrder())   // or .sorted((a,b) -> Integer.compare(b,a)
                .skip(1)
                .limit(1)
                .collect(Collectors.toList());
        System.out.println(result);



        /*
        * 2. Given a String, return the count of characters that are occurring more than once
        * */

            String word = "hellohowareyou";

            Map<Character, Long> answer = word.chars()
                    .mapToObj( c -> (char) c)
                    .collect(Collectors.groupingBy( c -> c, Collectors.counting()))
                    .entrySet()
                    .stream()
                    .filter(c -> c.getValue() > 1)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(answer);
    }
}
