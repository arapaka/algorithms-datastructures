package LeetCode.arrays;

/**
 * Created by archithrapaka on 8/26/17.
 */
public class Search2d {

    public static boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0) {
            return false;
        }
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}};
        int[][] mat2 = {};
        int[][] mat3 = {{1, 2, 3}};

        System.out.print(searchMatrix(mat3, -1));
    }
}
