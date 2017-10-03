package LeetCode.arrays;

import java.util.Arrays;

import static LeetCode.arrays.MoveZeros.swap;

/**
 * Created by archithrapaka on 8/7/17.
 */
public class RemoveElement {

    //my solution
    public static int remove(int[] a , int x) {


        int j = 0;
        for (int i = 0; i < a.length; i++) {
             if(a[i] != x) {
                 swap(a,j++,i);
             }

        }
        for (int i = j; i < a.length; i++) {
            if(a[i] == x) {
                a[i] = 0;
            }
        }
        return j;
    }

    /**
     * When nums[j]nums[j] equals to the given value,
     * skip this element by incrementing jj.
     * As long as nums[j] \neq valnums[j]≠val,
     * we copy nums[j]nums[j] to nums[i]nums[i] and increment both indexes at the same time.
     * Repeat the process until jj reaches the end of the array and the new length is ii.

     This solution is very similar to the solution to Remove Duplicates from Sorted Array.
     Complexity analysis

     Time complexity : O(n).
     Assume the array has a total of nn elements, both i and j traverse at most 2n steps.

     Space complexity : O(1).
     * @param a
     * @param val
     * @return
     */
    public static int remove2(int[] a , int val) {
        int i = 0;
        for (int j = 0; j < a.length; j++) {
            if(a[j] != val) {
                a[i++] = a[j];
            }
        }
        return i;
    }

    /**
     * Approach #2 (Two Pointers - when elements to remove are rare) [Accepted]

     Intuition

     Now consider cases where the array contains few elements to remove.
     For example, nums = [1,2,3,5,4], val = 4nums=[1,2,3,5,4],val=4.
     The previous algorithm will do unnecessary copy operation of the first four elements.
     Another example is nums = [4,1,2,3,5], val = 4nums=[4,1,2,3,5],val=4.
     It seems unnecessary to move elements [1,2,3,5][1,2,3,5] one step left as the problem
     description mentions that the order of elements could be changed.

     Algorithm:

     When we encounter nums[i] = valnums[i]=val,
     we can swap the current element out with the last element
     and dispose the last one. This essentially reduces the array's size by 1.

     Note that the last element that was swapped in could be the value you want to remove itself
     . But don't worry, in the next iteration we will still check this element.
     * @param a
     * @param val
     * @return
     */
    public static int remove3(int[] a , int val) {
        int i = 0;
        int n = a.length;

        while (i < n) {
             if(a[i] == val) {
                 a[i] = a[n-1];
                 n--;
             }
             else {
                 i++;
             }
        }
        return n;
    }

    public static int removeElement(int[] A, int elem) {
        int l = A.length;
        for (int i=0; i<l; i++) {
            if (A[i] == elem) {
                A[i--] = A[l-- -1];
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,2,3};
        removeElement(nums,3);
        Arrays.stream(nums).forEach(element -> System.out.println(element));
    }
}
