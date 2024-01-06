package dsa.solutions.arrays.TwoPointer;

import java.util.Arrays;

/**
 * for Two-Pointer technique details, visit: <a href="https://github.com/prasad-guntakinda/cs-fundamentals">cs-fundamentals repo</a>
 */
public class ArrayReversal {

    public static  void main(String[] ar){
        int[] arr = {1,2,3,4,5};
        System.out.println("Before Reverse: "+ Arrays.toString(arr));
        reverseAnArray(arr);
        System.out.println("After Reverse: "+ Arrays.toString(arr));
        int[] arr2 = {5,6,7,8,9,10};
        System.out.println("Before Partial Reverse: "+ Arrays.toString(arr2));
        reversePartialArray(arr2, 1,3);
        System.out.println("After Partial Reverse: "+ Arrays.toString(arr2));

        // Reverse first 3 elements
        int[] arr3 = {2,4,6,8,10};
        System.out.println("Before Partial Reverse: "+ Arrays.toString(arr3));
        reversePartialArray(arr3, 0,2);
        System.out.println("Reverse First 3 elements: "+ Arrays.toString(arr3));

        // Reverse last 3 elements
        int[] arr4 = {1,3,5,7,9,11};
        System.out.println("Before Partial Reverse: "+ Arrays.toString(arr4));
        reversePartialArray(arr4, arr4.length-3,arr4.length-1);
        System.out.println("Reverse last 3 elements: "+ Arrays.toString(arr4));
    }
    public static void reversePartialArray(int[] ar, int startIndex, int endIndex){
        if(startIndex<0 && endIndex>ar.length){
            throw new RuntimeException("Invalid Input.");
        }
        while(startIndex<endIndex){
            int temp = ar[startIndex];
            ar[startIndex] = ar[endIndex];
            ar[endIndex] = temp;
            startIndex++;
            endIndex--;
        }

    }
    public static void reverseAnArray(int[] arr){
        int n = arr.length;
        int i=0;
        int j=n-1;
        // swap elements until both pointers meet.
        // below loop will be stopped either i==j or i>j
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

    }
}
