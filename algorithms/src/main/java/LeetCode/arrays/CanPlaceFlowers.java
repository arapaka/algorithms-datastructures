package LeetCode.arrays;

/**
 * Created by archithrapaka on 8/16/17.
 */
public class CanPlaceFlowers {


    public static boolean canPlace(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length && count < n; i++) {
            if(flowerbed[i] == 0) {
                int prev = (i == 0) ? 0 : flowerbed[i-1];
                int next = (i == flowerbed.length-1) ? 0 : flowerbed[i+1];

                if(next == 0 && prev == 0) {
                    flowerbed[i] = 1;
                   count++;
                }
            }

        }
        return count == n;
    }


    public static void main(String[] args) {
        int[] a = {1,0,1,0,1,0,1};
        int[] b = {1,0,0,0,1,0,0};

        int[] c = {1,0,0,0,1};

        System.out.println(canPlace(b,2));
       // System.out.println(canPlace(b,2));
        //System.out.println(canPlace(c,1));
    }
}
