package LeetCode.TwoPointers;

import java.util.Random;

/**
 * Created by archithrapaka on 4/16/17.
 */
public class KthSmallestElementLinearTime {


    static int kthSmallest(int[] a, int k) {

        Random r = new Random();
        int left = 0;
        int right = a.length - 1;

        while (left <= right) {
            int pivotIndex = r.nextInt(right - left + 1) + left;
            int newPivotIndex = partitionAroundPivot(a, pivotIndex, left, right);

            if (newPivotIndex == k - 1) {
                return a[newPivotIndex];
            } else if (newPivotIndex > k - 1) {
                right = newPivotIndex - 1;
            } else {
                left = newPivotIndex + 1;
            }
        }
        return -1;
    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // partition the array and send the position
    static int partitionAroundPivot(int[] a, int pivotIndex, int left, int right) {
        int pivotValue = a[pivotIndex];
        int newPivotIndex = left; // start from left
        swap(a, pivotIndex, right); // swap pivotIndex to right and traverse till there

        for (int i = left; i < right; i++) {
            if (a[i] <= pivotValue) {
                swap(a, i, newPivotIndex);
                newPivotIndex++;
            }
        }
        swap(a, right, newPivotIndex);
        return newPivotIndex;
    }

    public static void main(String[] args) {
        int[] a = {12, 3, 5, 7, 4, 19, 26};
        //System.out.print("the kth smallest element is :"+kthSmallest(a,3));

        Random r = new Random();
        int left = 0;
        int right = a.length - 1;
        int rand = r.nextInt(right - left + 1);
        printAroundRandomPivot(a, rand);
    }

    // method 2
    static void printAroundRandomPivot(int[] a, int pivotIndex) {
        int value = a[pivotIndex];
        int left = 0;
        int i = left;
        int right = a.length - 1;

        while (i <= right) {
            while (a[left] <= value && i <= right) i++;
            while (a[right] >= value && i <= right) right--;
            if (i <= right) {
                swap(a, i, right);
                i++;
                right--;
            }
        }
        for (int k = 0; k < i; k++) {
            System.out.print(a[k] + " ");
        }

        for (int k = i; k < a.length; k++) {
            System.out.print(a[k] + " ");
        }
    }
}
