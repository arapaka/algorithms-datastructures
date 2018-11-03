package geeksforgeeks.arrays;

/**
 * Created by archithrapaka on 6/20/17.
 * You are given a list of n-1 integers and these integers are in the range of 1 to n.
 * There are no duplicates in list
 */
public class FindTheMissingNumber {

    /**
     * Method 1
     * 1. Get the sum of numbers
     * total = n*(n+1)/2
     * 2  Subtract all the numbers from sum and
     * you will get the missing number.
     *
     * @param a
     * @return
     */
    public static int findMissingNum(int[] a, int range) {
        int sum = (range) * (range + 1) / 2;

        for (int i : a) {
            sum = sum - i;
        }
        return sum;
    }

    /**
     * XOR Method 2
     *
     * @param range
     */
    public static int findMissing(int[] a, int range) {
        int xor1 = 0;
        for (int i = 1; i <= range; i++) {
            xor1 ^= i;
        }

        int xor2 = 0;
        for (int i : a) {
            xor2 ^= i;
        }
        return xor1 ^ xor2;
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 4, 5, 6};
        System.out.println(findMissing(a, 6));
        System.out.println(findMissingNum(a, 6));
    }
}
