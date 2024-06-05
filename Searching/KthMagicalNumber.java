package dsa.solutions.Searching;

public class KthMagicalNumber {
    public static void main(String[] args) {
        solve(807414236, 3788, 38141);
    }

    public static int solve(int A, int B, int C) {
        System.out.println("A="+A+" B= "+B+" C="+C);
        long space = 1L*A*(Math.min(B,C));
        System.out.println("base: "+ (A>space));
        long left=1, right=space;
        long ans = 0L;
        while(left <=right){
            long mid = left+(right-left)/2;
            long count = findNumOfMultiples(mid, B, C);
            System.out.println("left: "+left+" right="+right+" mid= "+mid+" count="+count+" ans="+ans);
            if(count > A){
                right = mid-1;
            }else if(count < A){
                left = mid+1;
            }else{
                ans = mid;
                right = mid-1;
            }


        }
        int res = (int)(ans%1_000_000_007);
        System.out.println("res="+res);
        return res;
    }

    static long findNumOfMultiples(long mid, int B, int C){
        int gcd = gcd(B,C);
        int lcm = (B*C)/gcd;
        System.out.println("gcd: "+gcd+" lcm: "+lcm);
        return mid/B + mid/C - mid/lcm;

    }

    static int gcd(int B, int C){
        if(B<C){
            return gcd(C,B);
        }
        if(C == 0) return B;
        return gcd(C, B%C);
    }
}
