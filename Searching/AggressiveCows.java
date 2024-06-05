package dsa.solutions.Searching;

import  java.util.*;
import java.util.function.IntFunction;

public class AggressiveCows {

    public static void main(String[] args) {
        int[] stalls = new int[]{82, 61, 38, 88, 12, 7, 6, 12, 48, 8, 31, 90, 35, 5, 88, 2, 66, 19, 5, 96, 84, 95};
        int cows = 8;
        System.out.println("Ans = "+solve(stalls, cows));
    }
    public static int solve(int[] A, int B){
        List<Integer> list = new ArrayList<>();
        for (int j : A) {
            if (!list.contains(j))
                list.add(j);
        }
        Collections.sort(list);
        Integer[] arr = list.toArray(Integer[]::new);
    if(arr.length == 2 && B==2){
        return arr[1]-arr[0];
    }
    //define Search Space
    int left=1, right= arr[arr.length-1]-arr[0];
        System.out.println("Array: "+Arrays.toString(arr));
    int ans=1;
        while(left<=right){
        int mid = left+ (right-left)/2;
        System.out.println("left = "+left+" right = "+right+ " mid = "+mid +"ans="+ans);
        if(isItPossibleToArrangeCowsWitMidDist(arr,B,mid)){
            ans = mid;
            left = mid+1;
        }else{
            right = mid-1;
        }
    }

        return ans;

}

static boolean isItPossibleToArrangeCowsWitMidDist(Integer[] arr, int cows, int mid){
    int prev_cow_stall = arr[0];
    int placedCows = 1;
    for(int i=1;i<arr.length;i++){
        if(arr[i]>=(prev_cow_stall+mid)){
            placedCows++;
            prev_cow_stall=arr[i];
            if(placedCows == cows)
                return true;
        }
    }

    return false;
}
}
