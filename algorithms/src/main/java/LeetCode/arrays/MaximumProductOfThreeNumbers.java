package LeetCode.arrays;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers {

    public static long findMax(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 1]);
    }

    public static void main(String[] a) {
        int[] a1 = {-4, -3, -2, -1, 60};
    }
}
