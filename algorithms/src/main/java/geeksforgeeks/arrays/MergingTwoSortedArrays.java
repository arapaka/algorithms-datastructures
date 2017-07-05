package geeksforgeeks.arrays;

/**
 * Created by archithrapaka on 6/21/17.
 * Merge an array of size n into another array of size m+n
 */
public class MergingTwoSortedArrays {

    public static void mergeArrays(int[] n , int[] mPlusN) {
        int k = 0; // start index of mPlusN;
        int i = n.length; //
        int j = 0; // start index of N
        move(mPlusN,n.length);
        while (i < mPlusN.length && j < n.length) {
              if(mPlusN[i] <= n[j]) {
                  mPlusN[k] = mPlusN[i];
                  i++;
                  k++;
              }
              else {
                  mPlusN[k] = n[j];
                  k++;
                  j++;
              }
        }

        while (i < mPlusN.length) {
            mPlusN[k] = mPlusN[i];
            i++;
            k++;
        }

        while (j < n.length) {
            mPlusN[k] = n[j];
            k++;
            j++;
        }
    }

    public static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    /**
     * Move empty blocks to front of the array
     * @param mPlusN
     */
    public static void move(int[] mPlusN , int n) {
        int i = mPlusN.length-1;
        int j = mPlusN.length-1;
        while (i >= 0) {
            if(mPlusN[i] > 0) {
                mPlusN[j] = mPlusN[i];
                j--;
            }
            i--;
        }
        //
        int k = 0;
        while (k < n) {
            mPlusN[k++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] mPlusN = {2,7,7,0,0,17,0,0};
        int[] n = {5,8,12,14};
        mergeArrays(n,mPlusN);
        print(mPlusN);
    }
}
