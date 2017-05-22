package LeetCode.TwoPointers;

import java.util.Arrays;

/**
 * Created by archithrapaka on 4/13/17.
 * // Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

 // For example, given nums = [-2, 0, 1, 3], and target = 2.

 // Return 2. Because there are two triplets which sums are less than 2:
 */
public class ThreeSumLesser {

    public static int findLesserTriplets(int[] a , int target) {
        Arrays.sort(a);
        int count = 0;
        for (int i = 0; i < a.length-2; i++) {
            int j = i+1;
            int k = a.length-1;

            while (j < k) {
                int sum = a[i]+a[j]+a[k];
                if(sum < target) {
                    count += k-j;
                    System.out.print("("+a[i]+","+a[j]+","+a[k]+")");
                    j--;
                }
                if (sum > target) {
                    k--;
                }

            }
        }
        return count;
    }

    public static void main(String[] args){
        int[] a = {-2,0,1,3};
        int target = 2;
        int count = findLesserTriplets(a,target);
        System.out.println(count);
    }
}
