package codefights;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by archithrapaka on 5/20/17.
 */
public class PairsSum {

    int pairsSum(int[] a) {
        Arrays.sort(a);

        Set<Integer> set = new HashSet<>();

        for (int i : a) {
            set.add(i);
        }
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            int j = a.length - 1;

            while (i < j) {
                int pair = a[i] + a[j];
                if (set.contains(pair)) {
                    count++;
                }
                j--;

            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
