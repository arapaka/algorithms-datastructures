package tutorialHorizon.arrays;

/**
 * Created by archithrapaka on 7/19/17.
 */
public class SearchInRotatedSortedArray {

    public static int search(int[] a , int target) {
        int left = 0;
        int right = a.length-1;

        while (left <= right) {
                int mid = (left+right) >>> 1;

                if(a[mid] == target) {
                    return mid;
                }
                // left decreasing
            if(a[left] <= a[mid]) {
                     if(a[left] <= target && target <= a[mid]) {
                         right = mid-1;
                     }
                     else {
                         left = mid+1;
                     }
            }
            else {
                    if(target >= a[mid] && target <= a[right]) {
                        left = mid+1;
                    }
                    else {
                        right = mid-1;
                    }
            }

        }
        return -1;
    }

    public static void main(String[] args){
        int a[] = { 10, 11, 12, 1, 2, 3, 4, 5, 6, 7, 8 };
        System.out.println(search(a,5));
    }
}
