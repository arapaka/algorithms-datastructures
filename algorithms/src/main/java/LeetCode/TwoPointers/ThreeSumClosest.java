package LeetCode.TwoPointers;
import java.util.*;
/**
 * Created by archithrapaka on 4/13/17.
 */
public class ThreeSumClosest {

    public static int find3SumClosest(int[] a , int target) {
        Arrays.sort(a);
        int globalMin = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            int j = i+1;
            int k = a.length-1;

            while (i < k) {
                int sum = a[i] + a[j] + a[k];

                int currMin = Math.abs(target - sum);
                if(currMin == 0) {
                    return currMin;
                }
                if(currMin < globalMin) {
                    globalMin = currMin;
                }
                if(sum <= target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return globalMin;
    }
    public static void main(String[] args) {

    }
}
