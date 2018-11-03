package Facebook;

import java.util.Arrays;

/**
 * Created by archithrapaka on 4/22/17.
 */
public class ThreeSum {

    public static void find3Sum(int[] a, int target) {
        Arrays.sort(a);
        if (a == null || a.length == 0) {
            return;
        }
        int length = a.length;

        for (int i = 0; i < length - 2; i++) {
            if (a[i] == a[i + 1]) continue;

            int j = i + 1;
            int k = length - 1;

            while (j < k) {
                if (a[i] + a[j] + a[k] == target) {
                    j++;
                    k--;
                    while (j < k && a[k] == a[k + 1]) k--;
                    while (j < k && a[j] == a[j - 1]) j++;
                } else if (a[i] + a[j] + a[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 3, 5, 7, 7, 9, 9, 9, 10};
        int k = a.length - 1;
        int j = 0;

        while (j < k) {
            System.out.println(a[j]);
            System.out.println(a[k]);
            j++;
            k--;

        }
    }
}
