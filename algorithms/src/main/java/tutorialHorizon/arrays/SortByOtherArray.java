package tutorialHorizon.arrays;

import java.util.LinkedHashMap;
import java.util.Map;

import static tutorialHorizon.arrays.MergeSort.display;

/**
 * Created by archithrapaka on 7/4/17.
 */
public class SortByOtherArray {


    /**
     * Sort Array a based on the other Array o
     *
     * @param a
     * @param o
     */
    public static void sortByOtherArray(int[] a, int[] o) {

        // Array Elements Count
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (Integer i : o) {
            map.put(i, 0);
        }
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])) {
                map.put(a[i], map.get(a[i]) + 1);
                count++;
            }
        }
        // partition the array (left side and right side ) , left side elements from first array ,
        //  right side other elements
        quickSwap(a, map);

        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            while (freq > 0) {
                a[index] = entry.getKey();
                index++;
                freq--;
            }
        }
        // sort the other half
        QuickSort.quickSort(a, count, a.length - 1);

    }

    public static void quickSwap(int[] a, Map<Integer, Integer> map) {
        int i = 0;
        int j = a.length - 1;

        while (i < j) {
            while (i < j && map.containsKey(a[i])) {
                i++;
            }

            while (j >= 0 && !map.containsKey(a[j])) {
                j--;
            }

            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arrA = {7, 5, 2, 6, 9, 1, 4, 4, 2, 1, 10, 13, 5, 7, 8};
        int[] arrB = {2, 7, 5};
        sortByOtherArray(arrA, arrB);
        display(arrA);
    }
}
