package twopointer;

public class ReverseString {
    public void reverseString(char[] s) {

        int left = 0;
        int right = s.length-1;

        while(left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}

class Main {
    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        char[] s = {'h', 'a', 'n', 'n', 'a', 'a'};
        rs.reverseString(s);
        System.out.println(s);

        String word = "han iah";

        System.out.println();

        ValidPalindrome vp = new ValidPalindrome();

        System.out.println(vp.isPalindrome(word));

    }
}