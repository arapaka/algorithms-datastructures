package geeksforgeeks.arrays;

/**
 * Created by archithrapaka on 5/9/17.
 */
public class SearchInsertDeleteSortedArrays {

    public static int search(int[] a, int k) {
        if (a.length == 0 || a == null) {
            return -1;
        }
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = (high + low) / 2;

            if (a[mid] == k) {
                return mid;
            } else if (k > a[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void sortedInsert(int[] a, int k) {
        int position = findPos(a, k);
        int[] arrayCopy = new int[a.length + 1];


        int i = 0;
        for (i = 0; i < position; i++) {
            arrayCopy[i] = a[i];
        }
        arrayCopy[position] = k;

        int j = position + 1;
        while (i < a.length && j < arrayCopy.length) {
            arrayCopy[j++] = a[i++];
        }
        for (int y : arrayCopy) {
            System.out.println(y + " ");
        }
    }

    public static int findPos(int[] a, int k) {
        int low = 0;
        int high = a.length - 1;

        // greater than the last value
        if (k >= a[high]) {
            return high + 1;
        }
        if (k <= a[low]) {
            return low;
        }

        while (low <= high) {

            if (high - low == 1) {
                return low + 1;
            }

            int mid = (low + high) / 2;
            if (a[mid] <= k) {
                low = mid;
            }
            if (a[mid] > k) {
                high = mid;
            }
        }
        return low + 1;
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 6, 100};
        System.out.println("the index is :" + search(a, 100));
//      System.out.println("find insert postion for an sorted array 2 ==  " + findPos(a,5));
//        System.out.println("find insert postion for an sorted array 1 == " + findPos(a,4));
//        System.out.println("find insert postion for an sorted array 1 == " + findPos(a,3));
//        System.out.println("find insert postion for an sorted array 3 == " + findPos(a,7));
//        System.out.println("find insert postion for an sorted array 3 == " + findPos(a,99));
//        System.out.println("find insert postion for an sorted array 4 == " + findPos(a,101));
//        System.out.println("find insert postion for an sorted array 3 == " + findPos(a,22));
//        System.out.println("find insert postion for an sorted array 0 == " + findPos(a,-2));
        // sortedInsert(a,5);
        //sortedInsert(a,4);
        sortedInsert(a, -100);
    }
}
