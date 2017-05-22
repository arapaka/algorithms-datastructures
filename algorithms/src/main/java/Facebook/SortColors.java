package Facebook;

/**
 * Created by archithrapaka on 4/28/17.
 */
public class SortColors {

    public static void pivotSort(int[] a ) {

        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int i:a) {
            if(i == 0) {
              count0++;
            }
            else if(i == 1){
                count1++;
            }
            else {
                count2++;
            }
        }
        int i = 0;
        while (i < a.length) {

               while (count0 > 0) {
                   a[i++] = 0;
                   count0--;
               }
               while (count1 > 0) {
                   a[i++] = 1;
                   count1--;
               }
               while (count2 > 0) {
                   a[i++] = 2;
                   count2--;
               }
        }

        for (i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void swap(int left , int right , int[] a) {
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }
    public static void main(String[] args){
            int[] a = {1,0,0,2,1,1,0,2};
            pivotSort(a);
    }
}
