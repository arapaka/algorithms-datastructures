package LeetCode.arrays;

/**
 * Created by archithrapaka on 5/9/17.
 */
public class FindTheDuplicateNumber {

    // cannot modify array , no extra space , o(n)
    // all numbers within array between size 1 and n (inclusive)
    public static int findTheDuplicate(int[] nums) {

        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res  = res ^ nums[i];
        }
        return res;
    }


    public static void main(String[] args) {
        int[] a = {1,4,4,5,6,9};
        System.out.println(findTheDuplicate(a));
        StringBuilder sb = new StringBuilder();
    }
}
