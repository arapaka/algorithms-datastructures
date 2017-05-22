package LeetCode.TwoPointers;

/**
 * Created by archithrapaka on 4/17/17.
 */
public class SearchInRotatedArray {

    public static int binarySearch(int[] a , int k) {
        int low = 0;
        int high = a.length-1;

        while (low <= high) {
            int mid = (low+high)/2;
            if(mid == k) return mid;
            
            if(a[low] < a[mid]) { // if left is decreasing

                if(a[low] <= k && k < a[mid]) {
                    high = mid-1; // search in lower half
                } else {
                    low = mid +1; // search in second half
                }
            }

            else {

                if(a[mid] <= k && k <= a[high]) {
                    low = mid+1;
                }
                else {
                    high = mid-1;
                }
            }
        }
        return -1; // not found
    }

    public static void main(String[] args) {

    }
}
