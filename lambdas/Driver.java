package lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Driver {

        public static void main(String[] args) {

            Calculator addition = (a,b) -> (a+b);
            Calculator multiplication = (a, b) -> (a*b);

            int sum = addition.calculate(5,3);
            int mul = multiplication.calculate(5,3);

            System.out.println("Addition: " + sum);
            System.out.println("Multiplication: " + mul);
            System.out.println("_____________________________________________________________________");

            List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

            Predicate<Integer> isEven = n -> (n%2==0);

            List<Integer> evenNumbers = numbers.stream()
                    .filter(isEven)
                    .collect(Collectors.toList());

            System.out.println(evenNumbers);
            System.out.println("_____________________________________________________________________");


            List<String> names = Arrays.asList("john", "jane", "bob");
            Function<String, String> func = n -> (n.toUpperCase());
            List<String> upperNames = names.stream()
                                            .map(func)
                    .collect(Collectors.toList());

            System.out.println(upperNames);

            System.out.println("_____________________________________________________________________");

            List<String> words = Arrays.asList("apple", "kiwi", "aa", "fig");

            //sort by length
//            words.sort((a,b) -> Integer.compare(a.length(), b.length()));

            //using method reference
            words.sort(String::compareTo);
            System.out.println(words);



        }
}
