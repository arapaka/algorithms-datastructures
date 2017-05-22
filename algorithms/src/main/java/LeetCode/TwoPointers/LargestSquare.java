package LeetCode.TwoPointers;

/**
 * Created by archithrapaka on 4/16/17.
 */
public class LargestSquare {

    public int getMaxArea(int[][] matrix){
        if(matrix.length == 0 || null == matrix) {
            return 0;
        }

        int maxArea = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] t = new int[m][n];

        for (int i = 0; i < m; i++) {
             t[i][0] = matrix[i][0];
        }
        for (int j = 0; j < n; j++) {
            t[0][j] = matrix[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                    if(matrix[i][j] == 1) {
                        int min = Math.min(t[i-1][j],t[i][j-1]);
                        min = Math.min(min,t[i-1][j-1]);
                        t[i][j] = min+1;
                    } else {
                        t[i][j] = 0;
                    }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(t[i][j] > maxArea) {
                    maxArea = t[i][j];
                }
            }
        }
        return maxArea;
    }


    public static void main(String[] args){

    }
}
