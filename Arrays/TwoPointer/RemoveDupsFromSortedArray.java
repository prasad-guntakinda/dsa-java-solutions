package dsa.solutions.arrays.TwoPointer;

import java.util.Arrays;

public class RemoveDupsFromSortedArray {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,4,4,4,4,5};
        System.out.println("Initial Array = "+ Arrays.toString(arr));
        arr = removeDupsFromSortedArray(arr);
        System.out.println("After removing Duplicates = "+ Arrays.toString(arr));
        int[] arr2 = {1,5};
        System.out.println("Initial Array = "+ Arrays.toString(arr2));
        arr2 = removeDupsFromSortedArray(arr2);
        System.out.println("After removing Duplicates = "+ Arrays.toString(arr2));
    }

    public static int[] removeDupsFromSortedArray(int[] arr){
        if(arr.length ==0 || arr.length ==1){
            return arr;
        }
        int n=arr.length;
        int i=0; // first-pointer which is holding unique element's index
        int j=1; // second-pointer which iterates the array and find the duplicates
        while(j<n){
            if(arr[i] != arr[j]){
                arr[++i] = arr[j];
            }
            j++;
        }
        return Arrays.copyOfRange(arr, 0, i+1);
    }
}
