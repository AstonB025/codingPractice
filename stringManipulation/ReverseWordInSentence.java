package stringManipulation;

import java.util.*;

/*
* Intuition
1.Trim the sentence to remove leading/trailing spaces.
2.Split the sentence into words using space as delimiter.
3.Reverse the order of words.
* 4Join them back into a single string with a single space between words.
Handle multiple spaces by using split("\\s+") — it splits on one or more spaces.
* */

public class ReverseWordInSentence {
    public static String reverseWords(String sentence){

        if(sentence == null || sentence.trim().isEmpty()){
            return "";
        }

        sentence = sentence.trim();

//        String regex = "[,\\.\\s]+";
        /*
        * [ ] -> Match any one characters present inside the brackets
        * , -> comma
        * // -> separate
        * s -> white space character
        * + -> multiple char inside the []
        *
        * */

        String regex = "[\\s]+";

        String[] data = sentence.split(regex);

        StringBuilder result = new StringBuilder();


        for(int i=data.length-1; i>=0; i--){
            result.append(data[i]);

//            result.append(" "); // this gives an extra space at the end.
            
            if (i != 0) {
                result.append(" ");
            }
        }

        return result.toString();
    }
    public static void main(String[] args) {
        System.out.println(  reverseWords("Hello,   World Java"));
    }
}
