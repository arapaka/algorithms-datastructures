package LeetCode.arrays;

import java.util.Arrays;

/**
 * Created by archithrapaka on 8/6/17.
 */
public class MoveZeros {

    public static void moveZeros(int[] nums) {
        for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.length; cur++) {
            if (nums[cur] != 0) {
                swap(nums,lastNonZeroFoundAt++, cur);
            }
        }
    }
    public static void swap(int[] A, int i, int j){
        if(i!=j){
            A[i]^=A[j];
            A[j]^=A[i];
            A[i]^=A[j];
        }
    }

    public static void main(String[] args) {
        int[] a = {1,4,3,5,7,2,9,4};
        moveZeros(a);
        Arrays.stream(a).forEach(element -> System.out.print(element + " "));
    }
}
