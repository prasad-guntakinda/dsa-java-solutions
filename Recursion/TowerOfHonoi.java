package dsa.solutions.Recursion;

public class TowerOfHonoi {

    public static void main(String[] args) {
        int n = 3; // number of disks
        char tA = 'A'; // tower-A
        char tB = 'B'; // tower-B
        char tC = 'C'; // tower-C
        toh(n,tA, tC,tB);
    }

  static void toh(int n, char src, char des, char temp){
      if(n == 0)
          return;

      //move top n-1 disks from src to temp tower
      toh(n-1,src,temp,des);
      //move the last disk from src to des tower
      System.out.println(src+"->"+des);
      //move n-1 disks from temp to des via src
      toh(n-1,temp,des,src);
    }


}
