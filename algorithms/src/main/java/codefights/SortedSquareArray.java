package codefights;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by archithrapaka on 5/18/17.
 */
public class SortedSquareArray {


    static int[] sortedSquaredArray(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }

        List<Integer> negative = new ArrayList<>();
        // get all negative elements
        int i;
        for (i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                negative.add(array[i]);
            } else {
                break;
            }
        }

        if (negative.size() > 0) {
            Collections.reverse(negative);
        }

        int[] neg = new int[negative.size()];
        for (int k = 0; k < neg.length; k++) {
            int val = negative.get(k);
            neg[k] = val * val;
        }

        int[] pos = new int[array.length - neg.length];
        int j = 0;
        while (i < array.length && j < pos.length) {
            int posVal = array[i];
            i++;
            pos[j] = posVal * posVal;
            j++;
        }

        int[] merged = merge(neg, pos);
        return merged;
    }

    private static int[] merge(int[] neg, int[] pos) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] merged = new int[neg.length + pos.length];
        while (i < neg.length && j < pos.length) {

            if (neg[i] < pos[j]) {
                merged[k] = neg[i];
                i++;
                k++;
            } else if (pos[j] < neg[i]) {
                merged[k] = pos[j];
                j++;
                k++;
            } else {
                merged[k] = neg[i];
                i++;
                k++;
            }
        }
        while (i < neg.length) {
            merged[k] = neg[i];
            i++;
            k++;

        }
        while (j < pos.length) {
            merged[k] = pos[j];
            j++;
            k++;
        }
        return merged;
    }

    public static void main(String[] args) {
        int[] a = {-6, -4, 1, 2, 3, 5};
        int[] squared = sortedSquaredArray(a);
        for (int i : squared) {
            System.out.print(i + " ");
        }
    }
}
