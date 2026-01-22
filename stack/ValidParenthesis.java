package stack;

import java.util.*;

public class ValidParenthesis {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for(char c: s.toCharArray()){
            if(c=='(' || c=='[' || c=='{'){
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;

                char top = stack.pop();
                if(c==')' && top != '(') return false;
                if(c==']' && top != '[') return false;
                if(c=='}' && top != '{') return false;
            }
        }

        return stack.isEmpty();
    }
}

class Main {
    public static void main(String[] args) {
        ValidParenthesis obj1 = new ValidParenthesis();
        ValidParenthesis obj2 = new ValidParenthesis();

        String s1 = "()[]{}";
        String s2 = "([)]";

        System.out.println(obj1.isValid(s1));
        System.out.println(obj2.isValid(s2));


    }
}
