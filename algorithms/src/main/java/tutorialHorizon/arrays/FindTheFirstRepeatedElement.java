package tutorialHorizon.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by archithrapaka on 7/4/17.
 * Find the repeated element by it's index
 */
public class FindTheFirstRepeatedElement {

    public static int findRepeated(int[] a) {
        Set<Integer> set = new HashSet<>();

        int index = -1;

        for (int i = a.length-1; i >=0 ; i--) {
              if(set.contains(a[i])) {
                  index = i;
              }
              set.add(a[i]);
        }
        return index;
    }

    public static void main(String[] args) {
        int[] a = {1,3,3,9,9,8,0,0,3,1};
        System.out.println(findRepeated(a));
    }
}
