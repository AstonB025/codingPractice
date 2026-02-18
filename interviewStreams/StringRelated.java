package interviewStreams;

import java.util.*;
import java.util.stream.*;
public class StringRelated {
    public static void main(String[] args) {


        String word = "programminginjava";
        List<String> words = Arrays.asList("programming", "in", "java", "is", "fun", "and", "powerful");
        String sentence = "The world compliments those who dare";


        // int count = word.length();
        // System.out.println(count);

        //1. Count the number of characters in a string using streams.
        long countOfChars = word.chars()
                .count();
        System.out.println("Number of Characters are: " + countOfChars);

        /**/
        Map<Character, Long> charCount = word.chars()
                .mapToObj( c -> (char) c)
                .collect(Collectors.groupingBy(n -> n,
                        Collectors.counting()));
        System.out.println("Each character count: " + charCount);



        //2. Count vowels in a string using streams.
        long vowelsCount = word.chars()
                .filter( n -> (n=='a') || (n=='e') || (n=='i') || (n=='o') || (n=='u'))
                .count();
                /*Can use this as well
                    long vowelsCount = word.chars()
                    .filter(n -> "aeiou".indexOf(n) != -1)
                    .count();
                    // "aeiouAEIOU".indexOf(n) -> To handle upperCase
                */
        System.out.println("Number of vowels present in word: " + vowelsCount);



        //3. Reverse a string using Java 8.
         /*
         String reversed = new StringBuilder(word).reverse().toString();
         */
        String reverseWord = word.chars()
                .mapToObj( c -> String.valueOf((char) c))
                .reduce("", (a,b) -> b+a);
        System.out.println("Reversed word: " + reverseWord);


        //4. Find duplicate characters in a string using streams.
        Map<Character, Long> duplicateCharacters = word.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(n -> n,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .filter( n -> n.getValue() > 1)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue));
        System.out.println("Duplicate characters in the word: " + duplicateCharacters);


        //5. Find first non-repeated character in a string using streams.
        /*
            char is a primitive — it cannot hold null. Your code would crash with a NullPointerException if no non-repeated character exists
            Character is the wrapper class — it can hold null.
        */
        Character firstNonRepeated = word.chars()
                .mapToObj( c -> (char) c)
                .collect(Collectors.groupingBy(
                        n->n,
                        LinkedHashMap::new,
                        Collectors.counting()))
                .entrySet().stream()
                .filter( n -> n.getValue() ==1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        System.out.println("First Non Repeated Character: " + firstNonRepeated);



        //6. Check if a string is a palindrome using streams.
        // already done the reversal in previous example
        boolean isPalindrome = word.equals(reverseWord);
        System.out.println("Is the word Palindrome?: " + isPalindrome);

        //7. Find frequency of each character in a string using streams.
        Map<Character, Long> frequencyOfChar = word.chars()
                .mapToObj(n -> (char) n)
                .collect(Collectors.groupingBy(n -> n,
                        Collectors.counting()));
        System.out.println("Frequency of each character in a word: " + frequencyOfChar);


        //8. Sort characters in a string using streams.
        String sortedChars =  word.chars()
                .sorted()
                .mapToObj(n -> String.valueOf((char) n))
                .collect(Collectors.joining()); //`Collectors.joining()` — concatenates all strings together with no delimiter
        System.out.println("Sorted Charcters: " + sortedChars);


        //9. Remove duplicate characters from a string using streams.
        String noDuplicates = word.chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        System.out.println("String without duplicate characters: " + noDuplicates);


        //10. Find words starting with a specific letter using streams.
        List<String> specificWords = words.stream()
                .filter( n -> n.startsWith("p")) // to handle case sensitive - .filter(n -> n.toLowerCase().startsWith("p"))
                .collect(Collectors.toList());
        System.out.println("Words starting with S are: " + specificWords);


        //11. **Reverse each word in a sentence while keeping word order.** *(Brillio asked this)*
        /*
        Converts that array into a `Stream<String>` because arrays don't have `.stream()` method. That's it — just a bridge.
        sentence.split(" ") Splits the sentence into an array:
        */
        String reverseSentence = Arrays.stream(sentence.split(" "))
                .map(a -> new StringBuilder(a).reverse().toString())
                .collect(Collectors.joining(" "));
        System.out.println("Reversed sentence: " + reverseSentence);


        //12. Find the longest word in a sentence using streams.
        Optional<String> longestWord = Arrays.stream(sentence.split(" "))
                .max(Comparator.comparingInt(String::length));
        longestWord.ifPresentOrElse(value -> System.out.println("Longest Word: " + value), () -> System.out.println("Not found"));


        //13. Count words in a sentence using streams.
        long wordCount = Arrays.stream(sentence.split(" ")).count();
        System.out.println("No. of words in a sentence: " + wordCount);


        //14. Convert a sentence to title case (capitalize first letter of each word).
        String convertedSentence = Arrays.stream(sentence.split(" "))
                .map(w -> w.substring(0,1).toUpperCase() + w.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
        System.out.println("Title case sentence: " + convertedSentence);

        //15. Find all unique characters in a string preserving order.
        String uniqueCharc = word.chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        System.out.println("All unique characters in a string: " + uniqueCharc);

    }
}
