package dsa.solutions.arrays.TwoDimensional;

import java.util.Arrays;

public class SpiralOrderMatrix {

    public static void main(String[] args) {
        // Q1. Generate Spiral Matrix
        int[][] spiralMatrix = generateSpiralMatrix(5);
        for(int[] row: spiralMatrix){
            System.out.println(Arrays.toString(row));
        }
        
        //Q2. Print given Matrix in Spiral order
        int[][] mat = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printMatrixInSpiralOrder(mat);
    }

    /**
     * Print the given matrix in a spiral order
     * @param mat
     */
    private static void printMatrixInSpiralOrder(int[][] mat) {
    }

    private static int[][] generateSpiralMatrix(int matSize) {
        int[][] res = new int[matSize][matSize];

        if(matSize == 1){
            res[0][0] = 1;
            return res;
        }

        int i=0, j=0, count=0;
        while(matSize>1){

            for(int k=0;k<matSize-1;k++){
                res[i][j] = ++count;
                j++;
            }

            for(int k=0;k<matSize-1;k++){
                res[i][j] = ++count;
                i++;
            }

            for(int k=0;k<matSize-1;k++){
                res[i][j] = ++count;
                j--;
            }

            for(int k=0;k<matSize-1;k++){
                res[i][j] = ++count;
                i--;
            }

            i++;
            j++;
            matSize = matSize-2;
        }

        if(matSize == 1){
            res[i][j] = ++count;
        }
//System.out.println("result=================");
        return res;
    }
}
