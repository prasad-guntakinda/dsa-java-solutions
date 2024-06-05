package dsa.solutions.Recursion;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println("Original Array: "+Arrays.toString(arr));
        reverseArrayHelper(arr, 0, arr.length-1);
        System.out.println("Reversed Array: "+Arrays.toString(arr));
    }

    static void reverseArrayHelper(int[] arr, int left, int right){
        if(left>=right) return;
        swap(arr, left, right);
        System.out.println("left: "+left+"Right: "+right);
        // below gives stackoverflow because it always passes the same value without evaluation
        //reverseArrayHelper(arr, left++, right--);

        left++;
        right--;
        //as above expressions are already evaluated, we get new values in the below call
        reverseArrayHelper(arr, left, right);

        //Use left+1 and right+1 to avoid confusion. Use left++ only while writing inside the loops.
        //reverseArrayHelper(arr, left+1, right-1);

    }

    static void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
