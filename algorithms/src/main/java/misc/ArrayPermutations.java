package misc;

public class ArrayPermutations {

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void permute(int[] a, int i, int length) {
        if (i == length) {
            printArray(a, length);
        }

        for (int j = i; j < length; j++) {
            swap(a, i, j);
            permute(a, i + 1, length);
            swap(a, i, j);
        }
    }

    private static void printArray(int[] a, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 5, 7, 8};
        permute(a, 0, 5);
    }
}
