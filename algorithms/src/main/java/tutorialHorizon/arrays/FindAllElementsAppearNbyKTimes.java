package tutorialHorizon.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by archithrapaka on 7/20/17.
 */
public class FindAllElementsAppearNbyKTimes {

    // given an array of size N and Number K
    public static List<Integer> findAll(int[] a , int k) {
        Map<Integer,Integer> freq = new HashMap<>(a.length);

        for (Integer i : a) {
              if(freq.containsKey(i)) {
                  freq.put(i,freq.get(i)+1);
              }
              else {
                  freq.put(i,1);
              }
        }
        int n = a.length;

        List<Integer> list = new ArrayList<>();
        for (Map.Entry entry : freq.entrySet()) {
              if((int)entry.getValue() >  n/k) {
                  list.add((int)entry.getKey());
              }
        }
        return list;
    }


    public static void main(String[] args) {
        int[] arrA = { 2, 2, 4, 4, 3, 5, 3, 4, 4, 6, 4, 3, 3, 8 };
        List<Integer> list = findAll(arrA,4);

        System.out.println(list);
    }
}
