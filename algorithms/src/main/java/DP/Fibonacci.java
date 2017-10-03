package DP;

import java.math.BigDecimal;

/**
 * Created by archithrapaka on 8/29/17.
 */
public class Fibonacci {

    private static final long MEGABYTE = 1024L * 1024L;

    public static long fib(int n) {
        if(n <= 1) {
            return n;
        }
        long x = 1, y = 2;
        long ans = 0;
        for(int i=2;i<=n;i++) {
            ans = (x + y);
            x = y;
            y = ans;
        }
        return ans % 1000000007;
    }


    public static BigDecimal fact(int N) throws Exception {
      if(N < 0) {
          throw new IllegalArgumentException("Factorial cannot be a negative number !");
      }
      BigDecimal[] fact = new BigDecimal[N+1];
        fact[0] = BigDecimal.ONE;

        for (int i = 1; i <= N; i++) {
            fact[i] = fact[i-1].multiply(BigDecimal.valueOf(i));
        }
        return fact[N];
    }

    public static long bytesToMegabytes(long bytes) {
        return bytes / MEGABYTE;
    }

    public static void main(String[] args) throws Exception {
      System.out.print(fact(500));
       // System.out.println(checkEquals(s2,s3));
    }

    private static boolean checkEquals(String s, String s1) {
        s1.replaceAll("\n","");
        return s.equals(s1);
    }
}
