package arrays.twopointer;

import com.sun.security.jgss.GSSUtil;

public class IsValidPalindrome {

    public static void main(String[] args) {
        String str = "abcdedcba";
        System.out.println(str+" is Palindrome = "+isPalindrome(str));

        System.out.println("abcd"+" is Palindrome = "+isPalindrome("abcd"));
    }

    //
    public static boolean isPalindrome(String str){
        int n=str.length();
        int i=0;
        int j=n-1;
        while(i<j){
            if(str.charAt(i) == str.charAt(j)){
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }
}
