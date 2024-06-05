package dsa.solutions.Searching;

public class PaintersPartition {

    public static void main(String[] args) {

    }

    static public int paint(int A, int B, int[] C) {
        //find search space start point: which is max(arr) and end point: sum(array)
        long left = findMax(C), right=sum(C);
        long ans = 0L;
        while(left <= right){
            long mid = left+(right-left)/2;
            if(isMidLengthBoardsCanBePainted(C, A, mid)){
                ans = mid;
                right=mid-1;
            }else{
                left = mid+1;
            }
        }
        return (int)(ans%1_000_000_3);

    }

    static boolean isMidLengthBoardsCanBePainted(int[] boards, int noOfWorkers, long mid){
        int workers = 1;
        long curr_len=0L;
        for(int bLen: boards){
            if(curr_len+bLen<=mid){
                curr_len = curr_len+bLen;
            }else{
                workers++;
                curr_len = bLen;
            }
        }
        //check if work can be distributed within noOfWorkers with baoard Length len
        return workers <= noOfWorkers;
    }

   static long findMax(int[] arr){
        long ans = arr[0];
        for(int num: arr){
            ans = Math.max(ans, num);
        }
        return ans;
    }

    static long sum(int[] arr){
        long sum=0L;
        for(int num: arr)
            sum+=num;

        return sum;
    }
}
