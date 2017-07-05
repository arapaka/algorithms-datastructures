package tutorialHorizon.arrays;

/**
 * Created by archithrapaka on 7/4/17.
 */
public class FindRepeatitionsOfNumber {

    public static int findRepeations(int[] a , int x) {
        int i = findFirstOccurrence(a,0,a.length-1,x);

        if(i < 0) {
            return -1;
        }

        int j = findLastOccurrence(a,0,a.length-1,x);
        return j-i+1;

        // find the first Occurrence
    }

    // first Occurrence of the target
    public static int findFirstOccurrence(int[] a , int low , int high, int target) {
         if(low <= high) {

             int mid = (low+high) >>> 1;

             if(mid == 0 || a[mid] == target && a[mid-1] < target) {
                    return mid;
             }
             else if (a[mid] < target) {
                 return findFirstOccurrence(a,mid+1,high,target);
             }
             else {
                 return findFirstOccurrence(a,low,mid-1,target);
             }
         }
         return -1;
    }

    public static int findLastOccurrence(int[] a , int low , int high , int target) {
        if(low <= high) {
            int mid = (low+high) >>> 1;

            if(mid == a.length-1 || (a[mid+1] > target) && a[mid] == target) {
                return mid;
            }
            else if (a[mid] > target) {
                return findLastOccurrence(a,low,mid-1,target);
            }
            else {
                return findLastOccurrence(a,mid+1,high,target);
            }

        }
        return -1;
    }

    public static void main(String[] rags){
        int[] a = {3,3,3,3,4};
        System.out.println(findRepeations(a,3));
    }
}
