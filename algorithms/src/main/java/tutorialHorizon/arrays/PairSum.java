package tutorialHorizon.arrays;

import java.util.*;

/**
 * Created by archithrapaka on 7/1/17.
 */
public class PairSum {

    /**
     *
     * @param a
     * @param x
     */
    public static void findSumPair(int[]a , int x) {
        Arrays.parallelSort(a);
        int low = 0;
        int high = a.length-1;
        boolean found = false;
        while (low < high) {
               int sum = a[low]+a[high];

                if(sum == x) {
                    found = true;
                    System.out.println("(" + a[low]+","+a[high]+")");
                    low++;
                    high--;
                }

                if(sum > x) {
                    high--;
                }
                else if (sum < x) {
                    low++;
                }
        }
        if(!found) {
            System.out.println("No such Pair exists !");
        }
    }

    /**
     * O(n) space to find sum pair
     * @param target
     */
     public static void findSumPairWithMap(int[] a , int target) {
         Map<Integer,Integer> map = new HashMap<>();

         int index = 0;
         Set<Sums> set = new HashSet<>();

         for (Integer i :a) {
               if(map.containsKey(target-i)) {
                   Sums s = new Sums(i,target-i);
                     if(!set.contains(s)) {
                         set.add(s);
                     }
               }
              map.put(i,index++);
         }

         for (Sums s:set) {
             System.out.println("("+s.x+","+s.y+")");
         }
     }

    /**
     * pair class
     */
    private static class Sums {
         int x;
         int y;

         public Sums(int x , int y) {
             this.x = x;
             this.y = y;
         }

         @Override
        public boolean equals(Object s) {
             if (this == s) return true;
             if (!(s instanceof Sums)) return false;
             Sums p = (Sums) s;
             return (this.x == p.x) && (this.y == p.y);
         }

         @Override
         public int hashCode() {
             return (this.x + this.y);
         }
     }

    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 3,4, 5, 5,16, 17, 18, 19, 249};
        //findSumPair(a,269);
        //findSumPair(a,8);
        findSumPairWithMap(a,8);
        Sums A = new Sums(5,3);
        Sums B = new Sums(5,3);
        Set<Sums> set = new HashSet<>();
        set.add(A);
        set.add(B);
       // System.out.print(set.size());
    }
}
