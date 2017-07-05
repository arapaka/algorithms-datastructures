package tutorialHorizon.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by archithrapaka on 7/4/17.
 */
public class FindCommonElements3SortedArrays {

    public static List<Integer> findCommonElems(int[] a , int[] b , int[] c) {
        int i = 0;
        int j = 0;
        int k = 0;
        List<Integer> common = new ArrayList<>();

        while (i < a.length && j < b.length && k < c.length) {

            if(a[i] == b[j] && b[j] == c[k]) {
                    common.add(a[i]);
                    i++;
                    j++;
                    k++;
             }

            else if (a[i] < b[j]) {
                i++;
            }
            else if (b[j] < c[k]) {
                j++;
            }
            else {
                k++;
            }
        }
        return common;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,10};
        int[] b = {1,3,5,6,7,8,12};
        int[] c = {2,3,4,5,8,9};
        System.out.println(findCommonElems(a,b,c));
    }
}
