package dsa.solutions.Arrays.TwoDimensional;

/**
 * Problem Description
 * Given a matrix of integers A of size N x M and an integer B.
 * In the given matrix every row and column is sorted in non-decreasing order. Find and return the position of B in the matrix in the given form:
 * If A[i][j] = B then return (i * 1009 + j)
 * If B is not present return -1.
 *
 * Note 1: Rows are numbered from top to bottom and columns are numbered from left to right.
 * Note 2: If there are multiple B in A then return the smallest value of i*1009 +j such that A[i][j]=B.
 * Note 3: Expected time complexity is linear
 * Note 4: Use 1-based indexing
 */
public class SearchAnElementInSortedArray {
    public static void main(String[] args) {
        int[][] ar = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("element = 5, res = "+ findElement(ar, 5));
        System.out.println("element = 2, res = "+ findElement(ar, 2));
    }

    private static int findElement(int[][] ar, int element){
        int i=0, j=ar[0].length-1, ans = Integer.MAX_VALUE;

        while(i<ar.length && j>=0){
            if(ar[i][j] == element){
                ans = Math.min(ans, (i+1)*1009+(j+1));
                j--;
            }else if(ar[i][j] < element){
                i++;
            }else {
                j--;
            }
        }

        return (ans == Integer.MAX_VALUE)? -1 : ans;
    }
}
