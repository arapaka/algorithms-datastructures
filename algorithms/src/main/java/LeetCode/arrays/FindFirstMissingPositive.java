package LeetCode.arrays;

import java.util.Arrays;

/**
 * Created by archithrapaka on 8/2/17.
 */
public class FindFirstMissingPositive {

    public static int findFirstMissingPositive(int[] nums) {
        if(nums.length == 0) {
            return 1;
        }

        // partition the positive numbers and get their length
        int k = partition(nums)+1;
        // fix the boundary
        int first_index = k;

        int temp = 0;
        for (int i = 0; i < k; i++) {
            temp = Math.abs(nums[i]);

            if(temp <= k) {
                 if(nums[temp-1] > 0) {
                     nums[temp-1] = -nums[temp-1];
                 }
            }
        }

        // run through the array and mark the non negative index
        for (int i = 0; i < k; i++) {
            if(nums[i] > 0) {
                first_index = i;
            }
        }
        return first_index+1;
    }


    public static int partition(int[] A) {
        int n = A.length;
        int q = -1;

        for (int i = 0; i < n; i++) {
             if(A[i] > 0) {
                 q++;
                 swap(A,q,i);
             }
        }
        return q;
    }

    public static void swap(int[] A , int q , int i) {
        int temp = A[i];
        A[i] = A[q];
        A[q] = temp;
    }

    // separate even and odd

    public static void exchange(int[] a) {
        int low = 0;
        int right = a.length-1;

        while (low < right) {
               while (low < right && a[low] > 0) {
                   low++;
               }
               while (low < right && a[right] < 0) {
                   right--;
               }
               if(low < right) {
                   int temp = a[low];
                   a[low] = a[right];
                   a[right] = temp;
                   low++;
                   right--;
               }
        }
    }


    public static int[] partitionEvenOdd(int[] a) {
            int N = a.length-1;
            int q = -1;
        for (int i = 0; i <= N; i++) {
            if(a[i] % 2 == 0) {
                q++;
                swap(a,q,i);
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {2};
        int[] b = {3,4,-1,2,1,-2,3,-5};
        int[] c = {1,2,3,4,5,6,7,8,9,10,12,14};
       // exchange(b);
        //Arrays.stream(b).forEach(element -> System.out.print(element + " "));
        //System.out.println(findFirstMissingPositive(a));
        //System.out.println(findFirstMissingPositive(b));
        //partition(b);
        //Arrays.stream(b).forEach(element->System.out.println(element + " "));
        Arrays.stream(partitionEvenOdd(c)).forEach(element -> System.out.println(element + "  "));
    }
}
