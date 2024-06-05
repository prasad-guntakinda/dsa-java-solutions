package dsa.solutions.Stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedParenthesis {

    public static void main(String[] args) {
        String input1 = "[{}]()";
        System.out.println(input1+" is Balanced: "+isParenthesisBalanced(input1));

        String input2 = "[{}](";
        System.out.println(input2+" is Balanced: "+isParenthesisBalanced(input2));

        String input3 = "[[[[(";
        System.out.println(input3+" is Balanced: "+isParenthesisBalanced(input3));

    }

    public static boolean isParenthesisBalanced(String str){
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c == '{' || c == '[' || c == '('){
                stack.push(c);
            } else if(c == '}' || c == ']' || c == ')'){
                if(stack.isEmpty())
                    return false;

                char top = stack.pop();
                if(c == '}' && top != '{')
                    return  false;
                if(c == ']' && top != '[')
                    return  false;
                if(c == ')' && top != '(')
                    return  false;
            }

        }

        return stack.isEmpty();

    }
}
