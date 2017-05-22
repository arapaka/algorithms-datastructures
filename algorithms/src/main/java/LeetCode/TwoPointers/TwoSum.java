package LeetCode.TwoPointers;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by archithrapaka on 4/11/17.
 */
public class TwoSum {

    // brute 0(n*2)
    public static void findSum(int[] a, int target) {
        System.out.println();
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a.length; j++) {
                if(a[i]+a[j] == target) {
                    System.out.print("("+i+","+j+")");
                }
            }
        }
    }

    public static void findSumBetter(int[] a, int target){

        Map<Integer,Integer> map = new HashMap<>();
        for (Integer integer:a) {
             if(map.containsKey(target-integer)) {
                 System.out.print("(" + (target-integer) + ","+ integer + ")");
             } else {
                 map.put(integer,(target-integer));
             }
        }
    }

    public static void main(String[] args) {
        int[] a = {0,1,2,7,8,9,11,15};
        findSumBetter(a,9);
        findSum(a,9);
    }
}
