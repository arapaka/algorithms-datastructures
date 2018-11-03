package multiThreading;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Stream;

/**
 * Created by archith.rapaka on 6/22/17.
 */
public class BinarySearchForkJoin {

    public static int binarySearch(int[] a, int target) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(10);
        return forkJoinPool.invoke(new BinarySearchParallel(0, a.length - 1, a, target));
    }

    private static class BinarySearchParallel extends RecursiveTask<Integer> {
        int low;
        int high;
        int[] a;
        int target;

        public BinarySearchParallel(int low, int high, int[] a, int target) {
            this.low = low;
            this.high = high;
            this.a = a;
            this.target = target;
        }

        @Override
        protected Integer compute() {

            if (low <= high) {

                if (high - low <= 1000) {
                    return Arrays.binarySearch(a, target);
                } else {
                    int mid = (low + high) >>> 1;
                    BinarySearchParallel left = new BinarySearchParallel(low, mid, a, target);
                    BinarySearchParallel right = new BinarySearchParallel(mid + 1, high, a, target);
                    invokeAll(left, right);
                    return Math.max(left.join(), right.join());
                }

            }
            return -1;
        }
    }


    public static void main(String[] args) {
        int[] a = {2, 5, 8, 10, 14, 44, 77, 78, 99};
        //int[] b = new int[1000000];
        Random rand = new Random();
        int[] b = new int[300000000];
        //System.out.println(rand.nextInt(100));
        for (int i = 0; i < 300000000; i++) {
            b[i] = rand.nextInt(100);
        }
        Arrays.parallelSort(b);

        LocalTime before = LocalTime.now(ZoneId.systemDefault());
        int bef = before.toSecondOfDay();
        System.out.println("start : " + bef);
        CompletableFuture<Integer> found1 = CompletableFuture.supplyAsync(() -> binarySearch(b, 77));
        CompletableFuture<Integer> found2 = CompletableFuture.supplyAsync(() -> binarySearch(b, 44));
        CompletableFuture<Integer> found3 = CompletableFuture.supplyAsync(() -> binarySearch(b, 99));
        CompletableFuture<Integer> found4 = CompletableFuture.supplyAsync(() -> binarySearch(b, 81));
        CompletableFuture<Integer> found5 = CompletableFuture.supplyAsync(() -> binarySearch(b, 89));
        CompletableFuture<Integer> found6 = CompletableFuture.supplyAsync(() -> binarySearch(b, 77));

        LocalTime now = LocalTime.now(ZoneId.systemDefault());
        int after = now.toSecondOfDay();
        System.out.println("after: " + after);
        Stream.of(found1, found2, found3, found4, found5, found6)
                .map(CompletableFuture::join)
                .forEach(result -> System.out.println(result));
        //System.out.println(combined);
    }
}
