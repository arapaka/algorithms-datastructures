package geeksforgeeks.arrays;

/**
 * Created by archithrapaka on 6/20/17.
 * Given an array of positive integers.
 * All numbers occur even number of times except one number which occurs odd number of times.
 * Find the number in O(n) time & constant space.
 */
//XOR OF ODD elements captures the odd element
public class FindTheNumberOccurringOddNumber {

    public static int findOddNumber(int[] a) {
        int xor = 0;
        for (int i:a) {
            xor = xor ^ i;
        }
        return xor;
    }

    public static void main(String[] args){
        int[] a = {2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2};
        System.out.println(findOddNumber(a));
    }
}
