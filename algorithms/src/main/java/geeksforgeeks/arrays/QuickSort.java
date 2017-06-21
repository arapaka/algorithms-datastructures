package geeksforgeeks.arrays;

/**
 * Created by archithrapaka on 6/19/17.
 */
public class QuickSort {

    /* The main function that
       implements QuickSort()
       arr[] --> Array to be sorted,
       low  --> Starting index,
       high  --> Ending index */
    static void sort(int[] a , int low , int high) {

        if(low < high) {

            /* pi is partitioning index, arr[pi] is
              now at right place */
            int partition = partition(a,low,high);
            // Recursively sort elements before
            // partition and after partition
            sort(a,low,partition-1);
            sort(a,partition+1,high);
        }

    }

    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    private static int partition(int[] a, int low, int high) {

        int pivot = a[high];
        int i = low-1;

        for (int j = low; j <= high-1; j++) {
              if(a[j] <= pivot) {
                  i++;
                  // swap arr[i] and arr[j]
                  int temp = a[i];
                  a[i] = a[j];
                  a[j] = temp;
              }

        }
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = a[i+1];
        a[i+1] = a[high];
        a[high] = temp;

        return i+1;
    }


    public static void main(String[] args) {

    }
}
