package dsa.solutions.Recursion;

/**
 * Problem Description
 * On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
 *
 * Given row number A and index B, return the Bth indexed symbol in row A. (The values of B are 0-indexed.).
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 20
 *
 * 0 <= B < 2A - 1
 * Example Input
 * Input 1:
 *
 *  A = 3
 *  B = 0
 * Input 2:
 *
 *  A = 4
 *  B = 4
 *
 *
 * Example Output
 * Output 1:
 *
 *  0
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Row 1: 0
 *  Row 2: 01
 *  Row 3: 0110
 * Explanation 2:
 *
 *  Row 1: 0
 *  Row 2: 01
 *  Row 3: 0110
 *  Row 4: 01101001
 */
public class KthSymbol {

//TODO: do it in recursion
    public int solve(int A, int B) {
        int[] curr_row={0};
        for(int i=1;i<A;i++){
            int[] new_row = new int[(int)Math.pow(2,i)];
            int new_row_index = -1;
            for(int element: curr_row){
                if(element == 0){
                    new_row[++new_row_index] = 0;
                    new_row[++new_row_index] = 1;
                }else {
                    new_row[++new_row_index] = 1;
                    new_row[++new_row_index] = 0;
                }
            }
            curr_row = new_row;
        }

        return curr_row[B];
    }
}
