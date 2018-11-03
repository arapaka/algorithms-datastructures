package geeksforgeeks.greedy;

import java.util.ArrayList;
import java.util.List;

//TODO , FIRST FIT AND DECREAING FIRST FIT
public class BinPacking {

    public static int findMinBins(int[] bins, int capacity) {
        //Arrays.sort(bins);
        int currentCapacity = 0;
        int numBins = 1;
        for (int c : bins) {
            currentCapacity += c;
            if (currentCapacity > capacity) {
                currentCapacity = currentCapacity - capacity;
                numBins++;
            }
        }
        List<Integer> list = new ArrayList<>();

        return numBins;
    }

    public static void main(String[] args) {
        System.out.println(findMinBins(new int[]{8, 5, 7, 7, 9, 7, 8}, 10));
        System.out.println(findMinBins(new int[]{9, 8, 2, 2, 5, 4}, 10));
        System.out.println(findMinBins(new int[]{2, 5, 4, 7, 1, 3, 8}, 10));
    }
}
