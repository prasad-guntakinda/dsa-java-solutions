package dsa.solutions.Hashing;

import java.util.Arrays;
import java.util.HashSet;

public class SubarraySumWithK {

    public static void main(String[] args) {
        int[] arr = { 2, 2, 1, -3, 4, 3, 1, -2, -3, 2 };
        int[] arr2 = { 2, 2, 1, 0, 2 };
        System.out.println(Arrays.toString(arr2));
        System.out.println(" Is Subarray Exists: "+isSubArrayExistsWithSumZero(arr2));
    }


    static boolean isSubArrayExistsWithSumZero(int[] arr){

        //calculate prefix Sum array
        int[] pfSum = new int[arr.length];
        pfSum[0] = arr[0];
        for(int i=1; i<arr.length;i++){
            pfSum[i] = pfSum[i-1]+arr[i];
        }

        HashSet<Integer> duplicates = new HashSet();
        for (int sum : pfSum) {
            if (sum == 0 || duplicates.contains(sum)) {
                return true;
            } else {
                duplicates.add(sum);
            }
        }
        return false;
    }
}
