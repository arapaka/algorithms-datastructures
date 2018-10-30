package tutorialHorizon.arrays;

public class CheckIfArrayIsSorted {

    public static boolean isSorted(int[] a) {
        return isSorted(a,a[0],0,a.length);
    }

    private static boolean isSorted(int[] a, int prevValue, int start, int end) {
        if(start == end) {
            return true;
        }
        return prevValue <= a[start] ? isSorted(a,a[start],++start,end) : false;
    }

    public static void main(String[] args) {
        int[] a = {1,3,5,7};
        int[] a1 = {2,3,4,2};
        int[] a2 = {0,0,0,0,0};
        System.out.println(isSorted(a));
        System.out.println(isSorted(a1));
        System.out.println(isSorted(a2));
    }
}
