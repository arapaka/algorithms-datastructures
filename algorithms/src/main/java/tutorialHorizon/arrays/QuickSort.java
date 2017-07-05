package tutorialHorizon.arrays;

/**
 * Created by archithrapaka on 7/1/17.
 */
public class QuickSort {

    public static void sort(int[] a) {
        quickSort(a,0,a.length-1);
    }

    public static void quickSort(int[] a , int low , int high) {
        int left = low;
        int right = high;
        int mid = (low+high) >>> 1;
        int pivot = a[mid];

        while (left <= right) {
                while (a[left] < pivot && left<=right) {
                    left++;
                }

                while (a[right] > pivot && left<= right) {
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
            quickSort(a,left,high);
        }

        if(low < right) {
            quickSort(a,low,right);
        }

    }

    public static void display(int[]a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int[] a = {87,-9,5,2,-4};
        sort(a);
        display(a);
    }
}
