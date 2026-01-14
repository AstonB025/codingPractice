package collections;

import java.util.*;

public class TopKFrequentElements {

    public static List<String> topKFrequent(List<String> words, int k){

        // Counting the frequencies by using a HashMap
        Map<String, Integer> frequencyMap = new HashMap<>();
        for(String word : words){
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0)+1);
        }

        // for sorting, using a List and put words into it
        List<String> wordList = new ArrayList<>(frequencyMap.keySet());

        System.out.println(wordList);

//        Collections.sort(wordList, (w1, w2) -> {
//            int freqCompare = frequencyMap.get(w2) - frequencyMap.get(w1); // descending frequency
//            if (freqCompare == 0) {
//                return w1.compareTo(w2); // alphabetical order if tie
//            }
//            return freqCompare;
//        });

        // Step 4: Return top k
        return wordList.subList(0, k);
    }


    static class wordComparator implements Comparator<String> {

        private Map<String, Integer> frequencyMap;

        public wordComparator(Map<String, Integer> frequencyMap){
            this.frequencyMap = frequencyMap;
        }

        @Override
        public int compare(String word1, String word2) {
            int freq1 = frequencyMap.get(word1);
            int freq2 = frequencyMap.get(word2);

            if( freq1 != freq2){
                return freq2 - freq1; // descending order
            }
            return word1.compareTo(word2);  //compares the string char by char and returns the ascending
        }
    }

    public static void main(String[] args) {



        List<String> words = Arrays.asList("cherry", "banana","apple", "banana", "apple", "cherry", "banana", "apple", "cherry", "cherry");

        List<String> result = topKFrequent(words, 2);
        System.out.println(result);
    }
}
