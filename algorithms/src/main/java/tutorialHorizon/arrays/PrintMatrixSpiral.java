package tutorialHorizon.arrays;

/**
 * Created by archithrapaka on 7/1/17.
 */
public class PrintMatrixSpiral {

    public static void print(int[][] a, int row, int col) {
        if (!isValid(a, row, col)) {
            return;
        }

        /**
         * this mean the mid point of the spiral is reached
         */
        if (row == col && row == a.length >>> 1) {
            System.out.println(a[row][col]);
            return;
        }

        int rowStart = row;
        int colStart = col;
        int colEnd = a[0].length - 1 - rowStart;
        int rowEnd = a.length - 1 - row;
        printRight(a, rowStart, colStart, colEnd);
        printDown(a, rowStart + 1, rowEnd, colEnd);
        printLeft(a, rowEnd, colEnd - 1, col);
        printUp(a, rowEnd - 1, row + 1, col);
        print(a, row + 1, col + 1);
    }

    private static void printUp(int[][] a, int rowStart, int rowEnd, int col) {
        while (rowStart >= rowEnd) {
            System.out.print(a[rowStart][col] + " ");
            rowStart--;
        }
        System.out.println();
    }

    private static void printLeft(int[][] a, int rowEnd, int colStart, int colEnd) {
        while (colStart >= colEnd) {
            System.out.print(a[rowEnd][colStart] + " ");
            colStart--;
        }
        System.out.println();
    }

    private static void printDown(int[][] a, int rowStart, int rowEnd, int colEnd) {
        while (rowStart <= rowEnd) {
            System.out.print(a[rowStart][colEnd] + " ");
            rowStart++;
        }
        System.out.println();
    }

    private static void printRight(int[][] a, int row, int colStart, int colEnd) {
        while (colStart <= colEnd) {
            System.out.print(a[row][colStart] + " ");
            colStart++;
        }
        System.out.println();
    }


    public static boolean isValid(int[][] a, int row, int col) {
        return row >= 0 && row < a.length && col >= 0 && col < a[row].length;
    }

    public static void main(String[] args) {

        int arrA[][] = {{1, 2, 3, 4, 5},
                {18, 19, 20, 21, 6},
                {17, 28, 29, 22, 7},
                {16, 27, 30, 23, 8},
                {15, 26, 25, 24, 9},
                {14, 13, 12, 11, 10}};
        //print(arrA,0,0);
        int[][] a = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        print(arrA, 0, 0);
        print(a, 0, 0);
    }
}
