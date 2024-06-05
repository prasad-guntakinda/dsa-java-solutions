package dsa.solutions.Arrays.TwoPointer;

import java.util.Arrays;

public class ArrayRotation {

    public static void main(String[] args) {
        int[] ar1 = {1,2,3,4,5,6,7,8};
        rotateArray(ar1, 5);
        int[] ar2 = {1,2,3,4,5,6,7,8};
        rotateArray(ar2, 25);
        int[] ar3 = {1,2,3,4,5,6,7,8};
        rotateArray(ar3, 19);

    }

    //Rotate an array with K times
    public static void rotateArray(int[] ar, int k){
        System.out.println("Before Rotation: "+ Arrays.toString(ar));
        int n = ar.length;
        if(k>n){
            k = (k)%n;
        }
        //Step-1: Rotate Complete Array Once
        reverse(ar, 0, n-1);
        //Step-2: Rotate first K elements
        reverse(ar, 0, k-1);
        //Step-3: Rotate (n-k) elements
        reverse(ar, k, n-1);
        System.out.println("After Rotating "+k+" times array: " + Arrays.toString(ar));
    }

    private static void reverse(int[] ar, int startIndex, int endIndex) {
        while(startIndex < endIndex){
            int temp = ar[startIndex];
            ar[startIndex] = ar[endIndex];
            ar[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }
}
