package twopointer;

public class ValidPalindrome {
    public boolean isPalindrome(String s){

     //empty string is considered as palindrome.
        if(s.isEmpty()) return true;

        int left = 0;
        int right = s.length()-1;

        while(left <= right){
            char start = s.charAt(left);
            char end = s.charAt(right);

            if(!Character.isLetterOrDigit(start)){
                left++;
            } else if (!Character.isLetterOrDigit(end)){
                right--;
            } else {
                if(Character.toLowerCase(start) != Character.toLowerCase(end)){
                    return false;
                }
                left++;
                right--;
            }
        }

        return true;
    }
}
