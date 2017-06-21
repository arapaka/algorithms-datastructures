package geeksforgeeks.arrays;

/**
 * Created by archithrapaka on 6/20/17.
 */
public class SearchInARotatedArray {

    public static int findNumber(int[] a , int target) {
        int start = 0;
        int end = a.length-1;

        while (start <= end) {
            int mid = (start + end)/2;

             if(a[mid] == target) {
                 return mid;
             }
            if (a[start] <= a[mid]) {

                   if(target >= a[start] && target <= a[mid]) {
                      end = mid-1;
                   }
                 else {
                       start = mid+1;
                   }
             }
            else if(target >= a[mid] && target <= a[end])  {
                 start = mid+1;
             } else {
                 end = mid-1;
             }
        }
        return -1;
    }

    // recursive method
    public static int findInRotatedArray(int[] a , int target , int low , int high) {

        while (low <= high) {

            int mid = (low+high)/2;

            if(a[mid] == target) {
                return mid;
            }

            // if a[left...mid] is sorted
            if(a[low] <= a[mid]) {

                // search left half if
                if(target >= a[low] && target <= a[mid]) {
                    return findInRotatedArray(a,target,low,mid-1);
                }
                // search in right half
                else {
                    return findInRotatedArray(a,target,mid+1,high);
                }
            }
            else if (target >= a[mid] && target <= a[high]) {
                return findInRotatedArray(a,target,mid+1,high);
            } else {
                return findInRotatedArray(a,target,low,mid-1);
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] a = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        System.out.println(findNumber(a,6));
        System.out.println(findInRotatedArray(a,6,0,a.length-1));
    }
}
