package LeetCode.arrays;

import java.util.Arrays;

/**
 * 561. Array Partition I
 * Created by archithrapaka on 8/1/17.
 * Given an array of 2n integers,
 * your task is to group these integers into n pairs of integer,
 * say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi)
 * for all i from 1 to n as large as possible.
 */
public class ArrayPartition1 {

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int sum = 0;

        while (i < nums.length) {
            sum += nums[i];
            i = i + 2;
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
