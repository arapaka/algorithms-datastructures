package LeetCode.arrays;

/**
 * Created by archithrapaka on 8/26/17.
 */
public class MaxConsecutiveOnes {


    public static int maxOnes(int[] nums) {

        int count = 0;
        int MaxCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                MaxCount = Math.max(MaxCount, count);
            } else
                count = 0;
        }
        return MaxCount;
    }


    public static void main(String[] args) {
        int[] a = {0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0};
        System.out.println(maxOnes(a));
    }
}
