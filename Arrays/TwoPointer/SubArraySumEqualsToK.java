package dsa.solutions.Arrays.TwoPointer;

public class SubArraySumEqualsToK {

    public static void main(String[] args) {
        var ar1 = new int[]{1,2,3,4,5,6};
        var k1 = 6;
        // subarrays: [1,2,3], [6]
        System.out.println("subarrays count: "+subarraysCountWithSumK(ar1,k1));

        var ar2 = new int[]{0,0,0,1,2,3,3,3,4,5,6,6,6,6};
        var k2 = 6;

        // subarrays: [0,0,0,1,2,3], [0,0,1,2,3], [0,1,2,3] , [1,2,3], [3,3], [3,3], [6], [6], [6], [6],
        //count: 10
        System.out.println("subarrays count: "+subarraysCountWithSumK(ar2,k2));

    }

    //Assumptions:
    //1. All the elements are +ve numbers
    // 2. All the elements are sorted

    public static int subarraysCountWithSumK(int[] ar, int k){
        int ans = 0;
        var pfSum = createPrefixSumArray(ar);
        //As array has all the +ve numbers we will get pfSum as a sorted array
        //Finding two-diff === k in sorted array is nothing but subarray sum
        int i=0, j=1;
        if(pfSum[0] == k){
            ans++;
        }
        while(j<pfSum.length){
            var diff = pfSum[j] - pfSum[i];
            if(diff > k){
                i++;
            }else if(diff < k){
                j++;
            }else {
                if(pfSum[i] == pfSum[j]){
                    var freq = j-i;
                    ans += (freq*(freq-1))/2;
                }else {
                    var iTemp = pfSum[i];
                    var iCount = 0;
                    while(pfSum[i] == iTemp){
                        iCount++;
                        i++;
                    }
                    var jTemp = pfSum[j];
                    var jCount = 0;
                    while(j<pfSum.length && pfSum[j] == jTemp){
                        jCount++;
                        j++;
                    }
                    ans += (iCount*jCount);
                }

            }
        }

        return ans;
    }

    private static int[] createPrefixSumArray(int[] ar) {
        var pfSum = new int[ar.length+1];
        //adding dummy index to mitigate subarrays which starts from index = 0
        //Example [1,2,3,4,5,6] k =6 then sub arrays = [1,2,3], [6]
        pfSum[0] = 0;
        var j=1;
        for(int i=0;i<ar.length;i++){
            pfSum[j] = pfSum[j-1]+ar[i];
            j++;
        }
        return pfSum;
    }
}
