package geeksforgeeks.arrays;

/**
 * Created by archithrapaka on 6/20/17.
 */
public class LargestSumContiguousSubArray {

    // Kadane's Algorithm works only for all positive numbers
    public static int maxCtgsSubArray(int[] a) {
        int max_so_far = 0;
        int max_ending_here = 0;

        for (int i = 0; i < a.length; i++) {
            if (max_ending_here < 0) {
                max_ending_here = 0;
            }
            max_ending_here = max_ending_here + a[i];
            max_so_far = Math.max(max_so_far, max_ending_here);
        }
        return max_so_far;
    }

    //works for all positive elements
    public static void maxCtgs(int[] a) {
        int curr_max = 0;
        int max_so_far = 0;
        int start = -1;
        int end = -1;
        int max = a[0];

        for (int i = 0; i < a.length; i++) {
            //curr_max = Math.max(a[i] , curr_max + a[i]);
            curr_max = curr_max + a[i];

            if (a[i] > curr_max) {
                curr_max = a[i];
                start = i;
                end = i;
            }
            //max_so_far = Math.max(max_so_far,curr_max);
            if (curr_max > max_so_far) {
                max_so_far = curr_max;
                end = i;
            }
            max = Math.max(max, a[i]);
        }
        //for all negative numbers
        if (max_so_far == 0) {
            System.out.println("Maximum contiguous sum is :" + max);
            return;
        }

        System.out.println("Starting index: " + start);
        System.out.println("Ending Index: " + end);
        System.out.println("Maximum contiguous sum is :" + max_so_far);
    }

//    private static int findLargestNumber(int[] a) {
//        int max = a[0];
//
//        for (int i = 1; i < a.length; i++) {
//              max = Math.max(max,a[i]);
//        }
//        return max;
//    }

    public static void main(String[] args) {
        int a[] = {-2, -3, 10};
        //System.out.println(maxCtgs(a));
    }
}
