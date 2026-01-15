package stringManipulation;

import java.util.Arrays;

public class AreAnagrams {
    public static boolean areAnagrams(String str1, String str2){

        //case insensitive
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // ignore ALL spaces
        String string1 = str1.replaceAll("\\s+", "");
        String string2 = str2.replaceAll("\\s+", "");


        if(string1.length() != string2.length()){
            return false;
        }

        char[] array1 = string1.toCharArray();
        char[] array2 = string2.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);


        return Arrays.equals(array1, array2);
    }

    public static void main(String[] args) {

        System.out.println(areAnagrams("Silent", "listen"));;
        System.out.println(areAnagrams("hello", "hi"));

    }
}
