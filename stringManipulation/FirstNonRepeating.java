package stringManipulation;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeating {
    public static char firstNonRepeating(String str){


        if(str == null || str.isEmpty()){
            return '\0';
        }

        Map<Character, Integer> map = new HashMap<>();
        for(char c : str.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) +1);
        }

        for(char c : str.toCharArray()){
            if(map.get(c) == 1){
                return c;
            }
        }

        return '\0';
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeating("aabbcdeeff"));
        System.out.println(firstNonRepeating("aabbcc"));
        System.out.println(firstNonRepeating("abac"));
        System.out.println(firstNonRepeating("z"));
    }
}
