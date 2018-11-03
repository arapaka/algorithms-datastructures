package tutorialHorizon.arrays;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Random;

/**
 * Created by archith.rapaka on 6/22/17.
 */
public class MergeSort {
    private int[] numbers;
    private int[] helpers;

    public void sort(int[] a) {
        this.numbers = a;
        int values = a.length;
        this.helpers = new int[values];
        mergeSort(0, values - 1);
    }

    private void mergeSort(int low, int high) {

        if (low < high) {
            int mid = (low + high) >>> 1;
            mergeSort(low, mid);
            mergeSort(mid + 1, high);
            merge(low, mid, high);
        }
    }

    // merging array from a[low...mid] , a[mid+1...high]
    private void merge(int low, int mid, int high) {
        // fill the auxilary array
        for (int i = low; i <= high; i++) {
            helpers[i] = numbers[i];
        }
        int i = low;
        int j = mid + 1;
        int k = low;

        while (i <= mid && j <= high) {
            if (helpers[i] <= helpers[j]) {
                numbers[k] = helpers[i];
                i++;
                k++;
            } else {
                numbers[k] = helpers[j];
                j++;
                k++;
            }
        }

        while (i <= mid) {
            numbers[k++] = helpers[i++];
        }
//		while (j <= high) {
//			numbers[k++] = helpers[j++];
//		}
    }


    public static void display(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int[] a = {45, 1, 0, 5, 3, 5, 7};
        Random rand = new Random();
        int[] b = new int[300000000];
        //System.out.println(rand.nextInt(100));
        for (int i = 0; i < 300000000; i++) {
            b[i] = rand.nextInt(100000);
        }
        MergeSort mergeSort = new MergeSort();
        LocalTime before = LocalTime.now(ZoneId.systemDefault());
        int bef = before.toSecondOfDay();
        System.out.println("start : " + bef);
        mergeSort.sort(b);
        //Arrays.parallelSort(b); // new favourite always use when recods greater than million
        //Arrays.sort(b);
        LocalTime now = LocalTime.now(ZoneId.systemDefault());
        int after = now.toSecondOfDay();
        System.out.println("after: " + after);
        //System.out.println("seconds elapsed : " + (after - bef));
        //display(a);
    }
}
