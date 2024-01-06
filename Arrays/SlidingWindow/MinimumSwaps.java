package dsa.solutions.arrays.SlidingWindow;

/**
 * Given an array of integers A and an integer B, find and return the minimum number of swaps required to bring all the numbers less than or equal to B together.
 *
 * Note: It is possible to swap any two elements, not necessarily consecutive.
 * Input 1:
 *
 *  A = [1, 12, 10, 3, 14, 10, 5]
 *  B = 8
 *
 *  Output 1:
 *  2
 */
public class MinimumSwaps {

    public static void main(String[] args) {

    }

    public static int findMinSwaps(int[] A, int B){

            int winSize =0;

        for (int j : A) {
            if (j <= B) {
                winSize++;
            }
        }

            int start=0;
            int end = winSize-1;
            int elementCount = 0;
            int swapCount = Integer.MAX_VALUE;
            while(end < A.length){
                if(start == 0){
                    for(int i=start; i<=end; i++){
                        if(A[i] <= B){
                            elementCount++;
                        }
                    }

                }else {
                    if(A[start-1] <= B)
                        elementCount--;
                    if(A[end] <=B)
                        elementCount++;
                }

                swapCount = Math.min(swapCount, winSize-elementCount);
                start++;
                end++;

            }

            return swapCount;

    }
}
