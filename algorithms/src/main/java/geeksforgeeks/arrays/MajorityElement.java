package geeksforgeeks.arrays;

/**
 * Created by archithrapaka on 6/20/17.
 * Majority Element: A majority element in an array A[] of size n
 * is an element that appears
 * more than n/2 times
 * (and hence there is at most one such element).
 */
public class MajorityElement {

    /**
     * Moore's Voting Algorithm
     *
     * @param a
     * @return
     */
    public static int findMajorityElem(int[] a) {
        int maj_index = 0;
        int count = 1;
        // find candidate element in the array
        for (int i = 1; i < a.length; i++) {
            if (a[i] == a[maj_index]) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                maj_index = i;
                count = 1;
            }
        }

        // find if the candidate algo is the majority element
        int candidateCount = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == a[maj_index]) {
                candidateCount++;
            }
            if (candidateCount > a.length / 2) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
