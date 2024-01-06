package dsa.solutions.arrays.CarryForward;

public class ArrayCarryForwardApp {

    public static void main(String[] args) {
    // 1. AG Pairs
    // - Input: 'BCADEG' Output: 1
    //  - Input: 'ABGCDGAMGAKG' Output: 7
    //  - Input: 'AAAAAAAAAAG'  Output: 10
        calculateAGPairs("BCADEG");
        calculateAGPairs("ABGCDGAMGAKG");
        calculateAGPairs("AAAAAAAAAAG");

    // 2. Smallest sub array with min & max
      int[] input1 = {1,2,5,4,6,5,8,4,1,5,2};
      int[] input2 = {6,4,2,1,4,1,1,2,1,6,5};
      smallestSubArrayWithMinAndMax(input1);
      smallestSubArrayWithMinAndMax(input2);
    }

    private static int calculateAGPairs(String str) {
        //str = "ABGCDGAMGAKG";
        int gCount = 0;
        int pairCount = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == 'G') {
                gCount++;
            } else if (str.charAt(i) == 'A') {
                pairCount=pairCount+gCount;
            }
        }
        System.out.println("Number of AG pairs = " + pairCount);
        return pairCount;
    }
    private static int smallestSubArrayWithMinAndMax(int[] arr){
        int min = arr[0];
        int max = arr[0];
        for (int i=1;i<arr.length;i++){
            if(arr[i]<min){
                min = arr[i];
            }
            if(arr[i]>max){
                max = arr[i];
            }
        }
        // if array elements all are same then min and max values will be same
        //eg: [4,4,4,4]
        if(min == max){
            return 1;
        }
        int minIndex = -1;
        int maxIndex = -1;
        int smallestLength=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == min){
                minIndex = i;
                if(maxIndex != -1){
                    //maxIndex already present means [maxIndex, minIndex]
                    smallestLength = Math.min(smallestLength, (minIndex-maxIndex+1));
                }
            }else if(arr[i] == max){
                maxIndex = i;
                if(minIndex != -1){
                    //minIndex already present means [minIndex, maxIndex]
                    smallestLength = Math.min(smallestLength, (maxIndex-minIndex+1));
                }
            }
        }
        System.out.println("smallest subarray length = "+smallestLength);
        return smallestLength;
    }


}
