package collections;

import java.util.*;

public class RemoveDuplicates {

    public static List<Integer> removeDuplicates(List<Integer> numbers){

        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for(Integer num : numbers){
            if(!set.contains(num)){
                result.add(num);
                set.add(num);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1,2,2,3,1,4);

        System.out.println("Original List - " + input);
        List<Integer> ans = removeDuplicates(input);
        System.out.println(ans);
    }

}
