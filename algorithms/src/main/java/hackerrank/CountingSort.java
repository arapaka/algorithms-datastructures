package hackerrank;

/**
 * Created by archithrapaka on 4/9/17.
 */
public class CountingSort {

    public void countingSort() {

    }

    public static void main(String[] args) {
        //System.out.print(Integer.MAX_VALUE);
        int[] max = new int[100];
        int[] a = new int[]{5, 6, 6, 8, 4, 0, 0, 1};
        for (int i : a) {
            max[i]++;
        }
        for (int i = 0; i < 9; i++) {
            System.out.print(max[i] + " ");
        }
    }
}
