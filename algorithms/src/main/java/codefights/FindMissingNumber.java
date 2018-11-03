package codefights;

import java.util.Arrays;

/**
 * Created by archithrapaka on 5/27/17.
 */
public class FindMissingNumber {

    // o(nlogn) time complexity
    int missingNumber(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (i != arr[i]) {
                return i;
            }
        }
        return arr.length;
    }


    public static void main(String[] args) {

    }
}
