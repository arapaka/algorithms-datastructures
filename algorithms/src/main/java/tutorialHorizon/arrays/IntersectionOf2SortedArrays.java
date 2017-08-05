package tutorialHorizon.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by archithrapaka on 7/21/17.
 */
public class IntersectionOf2SortedArrays {

    public static void findIntersection(int[] a , int[] b) {
        int i = 0;
        int j = 0;

        List<Integer> common = new ArrayList();

        while (i < a.length && j < b.length) {
              if(a[i] == b[j]) {
                  common.add(a[i]);
                  i++;
                  j++;
              }
              else if (a[i] > b[j]) {
                  j++;
              }
              else {
                  i++;
              }
        }
        System.out.println(common);
    }



    public static void main(String[] args){
        int[] a = { 1, 2, 3, 6, 8, 10 };
        int[] b = { 4, 5, 6, 11, 15, 20 };
        findIntersection(a,b);
    }
}
