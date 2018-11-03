package geeksforgeeks.arrays;

import java.util.Arrays;

/**
 * Created by archithrapaka on 6/19/17.
 */
public class SumPair {

    public static void findSumPairs(int[] a, int x) {
        Arrays.sort(a);

        int i = 0;
        int j = a.length - 1;
        boolean found = false;
        while (i < j) {
            int sum = a[i] + a[j];

            if (sum == x) {
                found = true;
                System.out.println("(" + a[i] + "," + a[j] + ")");
                i++;
                j--;
            } else if (sum > x) {
                j--;
            } else {
                i++;
            }
        }
        if (!found) {
            System.out.println("there are no pairs matching the sum");
        }
    }

    //o(n) extra space and O(n) time if the range of integers is known

    public static void findSumPairsUsingMap(int[] a, int x) {
        int MAX = 100000; // Max size of Hashmap
        boolean[] map = new boolean[MAX];

        for (int i : a) {
            int sum = x - i;
            if (sum >= 0 && map[sum]) {
                System.out.println("The pair is (" + i + "," + sum + ")");
            } else {
                map[i] = true;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 45, 6, 10, -8};
        int sum = 16;
        findSumPairs(a, sum);
    }
}
