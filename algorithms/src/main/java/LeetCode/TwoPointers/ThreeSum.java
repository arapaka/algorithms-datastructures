package LeetCode.TwoPointers;

import java.util.Arrays;

/**
 * Created by archithrapaka on 4/11/17.
 */
public class ThreeSum {

    public static void find3Sum(int[] a , int target) {
        System.out.println();
        for (int i = 0; i < a.length-2; i++) {
            for (int j = i+1; j < a.length-1; j++) {
                for (int k = j+1; k < a.length; k++) {
                    if(a[i]+a[j]+a[k] == target) {
                        System.out.print("("+a[i]+","+a[j]+","+a[k]+")");
                    }
                }
            }
        }
    }

    // print only unique
    public static void find3SumBetter(int[]a , int target) {
         // if Array is not sorted , you may incur the cost of sorting it o(logn)
        Arrays.sort(a);
        Boolean found = false;
        for (int i = 0; i < a.length-2; i++) {
              if(i== 0 || a[i] > a[i-1]) {
                  for (int j = i+1; j < a.length-1; j++) {
                      int k = a.length-1;
                      while (j < k) {
                          int sum = a[i]+a[j]+a[k];
                          if(sum == target) {
                              found = true;
                              System.out.print("("+a[i]+","+a[j]+","+a[k]+")");
                              j++;
                              k--;

                              // handle duplicates
                              while (j < k && a[j] == a[j-1]) {
                                  j++;
                              }
                              while (j < k && a[k] == a[k+1]) {
                                  k++;
                              }
                          }
                          else if (sum < target) {
                              j++;
                          } else {
                              k--;
                          }
                      }
                  }
              }

        }
        if(!found) {
            System.out.print("No triplet with given target exists !");
        }
    }
    public static void main(String[] args){
        int[] a = {-1, 0, 1, 2, -1, -4};
        find3SumBetter(a,0);
        find3Sum(a,0);
    }
}
