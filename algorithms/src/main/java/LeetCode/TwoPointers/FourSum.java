package LeetCode.TwoPointers;

import java.util.Arrays;

/**
 * Created by archithrapaka on 4/11/17.
 */
public class FourSum {

    public static void fourSum(int[] a , int target) {
        for (int i = 0; i < a.length-3; i++) {
            for (int j = i+1; j < a.length-2; j++) {
                for (int k = j+1; k < a.length-1; k++) {
                    for (int l = k+1; l < a.length; l++) {
                        if(a[i]+a[j]+a[k]+a[l] == target) {
                            System.out.print("("+a[i]+","+a[j]+","+a[k]+","+a[l]+")");
                        }
                    }
                }
            }
        }
    }

    public static void fourSumBetter(int[] a , int target) {
        Arrays.sort(a);
        for (int i = 0; i < a.length-3; i++) {
            if(i != 0 && a[i] == a[i-1])
                continue;
            for (int j = i+1; j < a.length-2; j++) {
                if(j != i+1 && a[j] == a[j-1])
                    continue;
                int k = j+1;
                int l = a.length-1;
                while (k < l) {
                        int sum = a[i] + a[j]+a[k]+a[l];
                        if(sum == target) {
                            System.out.print("("+a[i]+","+a[j]+","+a[k]+","+a[l]+")");
                            k++;
                            l--;

                            // handle duplicates here
                            while (k < l && a[l] == a[l+1]) {
                                l--;
                            }
                            while (k < l && a[k] == a[k-1]) {
                                k++;
                            }
                        }
                        else if (sum < target) {
                            k++;
                        } else {
                            l--;
                        }
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] a = {1 ,0 ,-1 ,0 ,-2 ,2};
        fourSum(a,0);
        System.out.println();
        fourSumBetter(a,0);
    }
}
