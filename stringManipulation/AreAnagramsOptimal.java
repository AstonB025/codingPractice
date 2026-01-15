package stringManipulation;

import java.util.HashMap;
import java.util.Map;

public class AreAnagramsOptimal {
    public static boolean areAnagrams(String str1, String str2){

        //case insensitive
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // ignore ALL spaces
        String string1 = str1.replaceAll("\\s+", "");
        String string2 = str2.replaceAll("\\s+", "");

        Map<Character, Integer> map = new HashMap<>();

        for(char c : str1.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for(char c: str2.toCharArray()){
            if(!map.containsKey(c)){
                return false;
            }
            map.put(c, map.getOrDefault(c, 0) -1);
            if(map.get(c)  < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(areAnagrams("Silent", "listen"));;
        System.out.println(areAnagrams("hello", "hi"));
    }
}
