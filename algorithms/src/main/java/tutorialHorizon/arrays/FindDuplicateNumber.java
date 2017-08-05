package tutorialHorizon.arrays;

/**
 * Created by archithrapaka on 7/23/17.
 */
public class FindDuplicateNumber {

    public static int findDuplicate(int[] nums) {
        if (nums.length == 0 || nums == null)
            return 0;
        int low = 1, high = nums.length - 1, mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid)
                    count++;
            }
            if (count > mid)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }

    public static void main(String[] args){
       int[] a = {1,2,3,5,8,6,7,4,3};
       System.out.print(findDuplicate(a));
    }
}
