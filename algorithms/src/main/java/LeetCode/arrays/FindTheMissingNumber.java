package LeetCode.arrays;

public class FindTheMissingNumber {
    class Solution {
        public int missingNumber(int[] nums) {
            int sum = 0;
            for(int i = 0;i < nums.length;i++) {
                sum += nums[i];
            }
            int totalSum = findSum(nums.length);
            return totalSum-sum;
        }
        public int findSum(int N) {
            int sum = 0;
            for(int i = 0;i<=N;i++) {
                sum += i;
            }
            return sum;
        }
    }
}
