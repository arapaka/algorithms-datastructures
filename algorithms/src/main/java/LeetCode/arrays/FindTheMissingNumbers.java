package LeetCode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by archithrapaka on 5/9/17.
 * 448. Find All Numbers Disappeared in an Array
 */
public class FindTheMissingNumbers {

    // cannot modify array , no extra space , o(n)
    // all numbers within array between size 1 and n (inclusive)
    public static List<Integer> findTheDuplicate(int[] nums) {

        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i];
            if (nums[Math.abs(index) - 1] > 0) {
                nums[Math.abs(index) - 1] = -nums[Math.abs(index) - 1];
            }
        }

        for (int j = 1; j <= nums.length; j++) {
            if (nums[j - 1] > 0) {
                result.add(j);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] a = {4, 3, 1, 1, 2};
        System.out.println(findTheDuplicate(a));
        StringBuilder sb = new StringBuilder();
    }
}
