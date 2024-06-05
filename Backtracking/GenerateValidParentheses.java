package dsa.solutions.Backtracking;

public class GenerateValidParentheses {
    public static void main(String[] args) {
        //number of pairs we need to generate
        int n=3;
        //to maintain the state of the problem.
        //how many opened and closed till now
        int openCount=0, closeCount=0;
        //to maintain forming parenthesis
        String temp ="";
        //why not StringBuilder? if we use StringBuilder then while backtracking we may loose it's state for another possibililty
        //if we use StringBuilder then we keep on append and remove last char from it to achieve valid response.

        backtrack(n, temp, openCount, closeCount);
    }

    public static void backtrack(int n, String temp, int openCount, int closeCount){
        if(openCount+closeCount == 2*n){
            System.out.println(temp);
            return;
        }
        if(openCount<n)
            backtrack(n, temp+"(", openCount+1, closeCount);

        if(closeCount<openCount)
            backtrack(n, temp+")", openCount, closeCount+1);
    }
}
