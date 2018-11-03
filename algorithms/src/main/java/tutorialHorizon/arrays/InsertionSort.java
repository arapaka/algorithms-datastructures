package tutorialHorizon.arrays;

/**
 * Created by archithrapaka on 7/4/17.
 */
public class InsertionSort {

    public static void insertionSort(int[] items, int n) {
        int i, j;

        for (i = 1; i < n; i++) {
            j = i;
            while (j > 0 && (items[j] < items[j - 1])) {
                swap(items, j, j - 1);
                j--;
            }
        }
    }

    public static void swap(int[] items, int i, int j) {
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    public static void display(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int[] a = {100, 4, 30, 15, 98, 3};
        insertionSort(a, a.length);
        display(a);
    }

}
