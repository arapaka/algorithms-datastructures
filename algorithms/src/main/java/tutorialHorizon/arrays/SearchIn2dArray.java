package tutorialHorizon.arrays;

/**
 * Created by archithrapaka on 7/1/17.
 */
public class SearchIn2dArray {

    public static void search(int[][] a, int target) {
        searchIn2dArray(a, 0, a[0].length - 1, target);
    }

    /**
     * Recursive Search in 2d sorted array
     *
     * @param sortedArray
     * @param x
     * @param y
     * @param target
     */
    public static void searchIn2dArray(int[][] sortedArray, int x, int y, int target) {
        if (isValid(sortedArray, x, y)) {
            if (sortedArray[x][y] == target) {
                System.out.println("it is found at : (" + x + "," + y + ")");
                return;
            }
            /**
             * go down
             */
            else if (sortedArray[x][y] < target) {
                searchIn2dArray(sortedArray, x + 1, y, target);
            }
            // go left
            else {
                searchIn2dArray(sortedArray, x, y - 1, target);
            }
        }
    }

    public static boolean isValid(int[][] a, int x, int y) {
        return x < a.length && y < a[0].length;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3, 4}, {6, 7, 8, 9}, {13, 14, 15, 16},
                {17, 18, 19, 20}, {22, 23, 24, 26}};
        search(a, 18);
    }
}
