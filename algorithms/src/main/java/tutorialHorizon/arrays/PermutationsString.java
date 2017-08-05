package tutorialHorizon.arrays;

/**
 * Created by archithrapaka on 7/19/17.
 */
public class PermutationsString {

    public static void permutation(char[] arrA , int left , int right ) {
         if(left == right) {
             for (int i = 0; i < arrA.length; i++) {
                 System.out.print(arrA[i]);
             }
             System.out.println(" ");
         }
         else {
             int x;
             for (x = left; x < right; x++) {
                 swap(arrA, left, x);
                 permutation(arrA, left + 1, right);
                 swap(arrA, left, x);
             }
         }
    }

    public static void swap(char[] a , int x , int y) {
        char temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public static void main(String[] args) {
        String s = "abcd";
        permutation(s.toCharArray(),0,s.length());
    }
}
