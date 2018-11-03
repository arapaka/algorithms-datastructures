package codefights;

/**
 * Created by archithrapaka on 6/19/17.
 */
public class FirstDuplicate {

    static int findFirstDuplicate(int[] a) {

        for (int i = 0; i < a.length; i++) {
            int index = Math.abs(a[i]);
            if (a[index - 1] < 0) {
                return index;
            }
            a[index - 1] = -a[index - 1];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 3, 5, 1};
        System.out.println(findFirstDuplicate(a));
    }
}
