package tutorialHorizon.arrays;

/**
 * Created by archithrapaka on 7/4/17.
 * http://algorithms.tutorialhorizon.com/minimum-number-that-cannot-be-formed-by-any-subset-of-an-array/
 */
public class FindTheMinimumNumber {

    public static int findTheMinimumMissingNumber(int[] a) {
        int smallNumber = 1;

        for (int i = 0; i < a.length; i++) {
             if(a[i] <= smallNumber) {
                 smallNumber += a[i];
             }
             else {
                 break;
             }
        }
        return smallNumber;
    }

    public static void main(String[] args) {
        int[] a = {1,2,6,7,9};
        System.out.println(findTheMinimumMissingNumber(a));
    }
}
