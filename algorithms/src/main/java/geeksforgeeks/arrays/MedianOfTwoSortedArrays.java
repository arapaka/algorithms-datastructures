package geeksforgeeks.arrays;

import java.util.Arrays;

/**
 * Created by archithrapaka on 6/26/17.
 */
public class MedianOfTwoSortedArrays {
    String s;

    /*
     method 1 :
      Merge two arrays and find the median
      0(n)
     */
    public static double findMedian(int[] a, int[] b) {
        int[] aPlusb = mergeSortedArrays(a, b);
        Arrays.parallelSort(aPlusb);
        int length = aPlusb.length;
        if (length % 2 != 0) {
            return aPlusb[length / 2];
        } else {
            return (aPlusb[length / 2] + aPlusb[length / 2 - 1]) / 2.0;
        }
    }

    public static int[] mergeSortedArrays(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] merged = new int[a.length + b.length];

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                merged[k] = a[i];
                i++;
                k++;
            } else {
                merged[k] = b[j];
                j++;
                k++;
            }
        }
        while (i < a.length) {
            merged[k] = a[i];
            i++;
            k++;
        }
        while (j < b.length) {
            merged[k] = b[j];
            j++;
            k++;
        }
        return merged;
    }

    /**
     * find the Median of sorted array
     *
     * @param a
     * @return
     */
    public static int findMedian(int[] a) {
        int length = 0;
        if (length % 2 != 0) {
            return a[length / 2];
        } else {
            return (a[length / 2] + a[length / 2 - 1]) / 2;
        }
    }
    // median comparision , you don't need to merge the arrays

    public double findMedianSortedArray(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
    }

    private double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
        if (aStart > A.length - 1) return B[bStart + k - 1];
        if (bStart > B.length - 1) return A[aStart + k - 1];
        if (k == 1) return Math.min(A[aStart], B[bStart]);

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aStart + k / 2 - 1 < A.length) aMid = A[aStart + k / 2 - 1];
        if (bStart + k / 2 - 1 < B.length) bMid = B[bStart + k / 2 - 1];

        if (aMid < bMid)
            return getkth(A, aStart + k / 2, B, bStart, k - k / 2);// Check: aRight + bLeft
        else
            return getkth(A, aStart, B, bStart + k / 2, k - k / 2);// Check: bRight + aLeft
    }


    public static void main(String[] args) {
        int[] a = {1, 3};
        int[] b = {2, 4};
        //System.out.println(findMedian(a,b));
        double res = findMedian(a, b);
        System.out.println(res);
    }
}
