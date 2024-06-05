package dsa.solutions.BasicMath.PermCombs;

public class FindExcelTitle {
    public static void main(String[] args) {
        System.out.println(findExcelTitle(2));
        System.out.println(findExcelTitle(28));
        System.out.println(findExcelTitle(53));
        System.out.println(findExcelTitle(2002));
    }

    static String findExcelTitle(int num){
        StringBuilder ans = new StringBuilder("");
        while(num >0){
            //decrement to match zero-index
            num--;
            //0+'A' => A , 1+'A'=>B
            //remainder is always between [0,25] for base-26, if we add 'A' to the number it will give us valid char
            char currChar = (char) ('A'+ (num%26));
            System.out.println("curr num = "+num +" curr char = "+currChar);
            ans.append(currChar);
            num = num/26;
        }
        ans.reverse();
        return ans.toString();
    }
}
