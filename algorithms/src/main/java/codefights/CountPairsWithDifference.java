package codefights;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by archith.rapaka on 6/13/17.
 */
public class CountPairsWithDifference {

    private static ExecutorService executorService = Executors.newFixedThreadPool(3);


    public static void main(String[] args) {
        Foo foo = (x, y) -> count(x, y);
        Foo foo1 = new FooImpl();
        //System.out.println(foo1.add(5,4));
        //System.out.println(foo.add(5,4));
        //System.out.println(calculateFac(300));
//		Callable<Long> callable = (x) -> {
//		    	return calculateFac(x);
//		};
        //BigInteger diff = BigInteger.valueOf(10).subtract(BigInteger.valueOf(2));
        //BigInteger res = diff.divide(BigInteger.valueOf(2));

        Scanner sc = new Scanner(System.in);
        int cases = 3;
        List<BigInteger> list = new ArrayList<>();
        while (cases > 0) {
            BigInteger two = new BigInteger("2");
            BigInteger total = new BigInteger(sc.nextLine());
            BigInteger nad = new BigInteger(sc.nextLine());
            BigInteger diff = total.subtract(nad);
            BigInteger res = diff.divide(two);
            //System.out.println(total.subtract(res));
            //System.out.println(res);
            list.add(total.subtract(res));
            list.add(res);
            cases--;
        }
        for (BigInteger bi : list) {
            System.out.println(bi);
        }
    }

    private static int count(int x, int y) {
        return x * y;
    }

    private static BigInteger calculateFac(int n) {

        BigInteger one = new BigInteger("1");

        while (n != 0) {
            one = one.multiply(BigInteger.valueOf(n));
            n = n - 1;
        }
        return one;
    }

    private static class FooImpl implements Runnable, Foo {

        @Override
        public Integer add(int x, int y) {
            return x + y;
        }

        @Override
        public void run() {

        }
    }

    @FunctionalInterface
    interface Foo {
        Integer add(int x, int y);
    }

}
