package dsa.solutions.Hashing;

import java.util.HashSet;

public class PairSum {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 15;
        int res = isPairSumExists(arr, k);
        System.out.println("isPairSumExists: "+((res ==1)?"true":"false"));
    }

    private static int isPairSumExists(int[] arr, int k) {
        HashSet < Integer > set = new HashSet< Integer >();
        for(int i = 0 ; i < arr.length ; i++){
            if(set.contains(k - arr[i])){
                return 1;
            }
            set.add(arr[i]);
        }
        return 0;

    }


}
