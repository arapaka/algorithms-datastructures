package LeetCode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length - 2; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int k = j + 1;

                int l = nums.length - 1;

                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        k++;
                        l--;
                        List<Integer> num = new ArrayList<>();
                        num.add(nums[i]);
                        num.add(nums[j]);
                        num.add(nums[k]);
                        num.add(nums[l]);
                        list.add(num);
                        // handle duplicates here
                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                    } else if (sum > target) {
                        l--;
                    } else {
                        k++;
                    }
                }
            }

        }
        return list;
    }

    public static void fourSumBetter(int[] a, int target) {
        Arrays.sort(a);
        for (int i = 0; i < a.length - 3; i++) {
            if (i != 0 && a[i] == a[i - 1])
                continue;
            for (int j = i + 1; j < a.length - 2; j++) {
                if (j > i + 1 && a[j] == a[j - 1])
                    continue;
                int k = j + 1;
                int l = a.length - 1;
                while (k < l) {
                    int sum = a[i] + a[j] + a[k] + a[l];
                    if (sum == target) {
                        System.out.print("(" + a[i] + "," + a[j] + "," + a[k] + "," + a[l] + ")");
                        k++;
                        l--;

                        // handle duplicates here
                        while (k < l && a[l] == a[l + 1]) {
                            l--;
                        }
                        while (k < l && a[k] == a[k - 1]) {
                            k++;
                        }
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] S = {1, 0, -1, 0, -2, 2};
        Arrays.sort(S);
        //fourSumBetter(S,0);
        System.out.println(fourSum(S, 0));
    }
}
