package tutorialHorizon.arrays;

/**
 * Created by archithrapaka on 7/4/17.
 * Given an array of interg­ers, sort it such that the odd num­bers appear first fol­lowed by the even num­bers .
 * The odd num­bers in ascend­ing order and the even num­bers in descend­ing order.
 *
 */
public class SortOddEvenNumbersArray {

    /**
     * separate even and odd numbers
     * @param a
     */
    public static void sort(int[] a , int low , int high) {

        while (low < high) {
                     while (low < high && a[low] % 2 != 0) {
                         low++;
                     }
                     while (low < high && a[high] % 2 == 0) {
                         high--;
                     }
                     if(low < high) {
                         int temp = a[low];
                         a[low] = a[high];
                         a[high] = temp;
                         low++;
                         high--;
                     }
        }

    }

    public static void Quicksort(int[] a , int low , int high) {
        int left = low;
        int right = high;
        int mid = (high+low) >>> 1;

        int pivot = a[mid];

        while (left <= right) {
              while (left <= right && a[left] < pivot) {
                  left++;
              }
              while (left <=  right && a[right] > pivot) {
                  right--;
              }
              if(left <= right) {
                  int temp = a[left];
                  a[left] = a[right];
                  a[right] = temp;
                  left++;
                  right--;
              }
        }

        if(left < high) {
            Quicksort(a,left,high);
        }

        if(low < right) {
            Quicksort(a,low,right);
        }
    }

    public static void reverse(int start , int end , int[] a) {
            while (start < end) {
                 int temp = a[start];
                 a[start] = a[end];
                 a[end] = temp;
                 start++;
                 end--;
            }
    }

    public static void display(int[] a) {
        for (Integer integer : a) {
            System.out.print(integer + " ");
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,10};
        sort(a,0,a.length-1); // separate Odd even numbers
        //Quicksort(a,0,4);
        //int i = ;
        //reverse(0,5,a);
         int i = findTheOddIndex(a); // find the index of the last odd number
        // we have the odd numbers followed by the even numbers and the index of last odd number is i
        if(i != -1) {
            Quicksort(a,0,i); // sort odd numbers in ascending order
         }

         // Sort even number in descending order , we sort and reverse
        Quicksort(a,i+1,a.length-1);
        reverse(i+1,a.length-1,a);

        display(a);
    }

    private static int findTheOddIndex(int[] a) {
        int i = -1;
        for (int j = 0; j < a.length; j++) {
              if(a[j] % 2 == 0) {
                  i = j-1;
                  break;
              }
        }
        return i;
    }
}
