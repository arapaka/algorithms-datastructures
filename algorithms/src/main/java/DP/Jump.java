package DP;

/**
 * Created by archithrapaka on 4/9/17.
 */
public class Jump {


    public static int countStairsWays(int n) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }

        if(n == 3) {
            return 4;
        }
        int[] count = new int[n];
        count[0] = 1;
        count[1] = 2;
        count[2] = 4;
        for (int i = 3; i < n; i++) {
            count[i] = count[i-1]+count[i-2]+count[i-3];
        }
        return count[n-1];
    }

    public static int countStairsMWays(int n,int m) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }

        if(n == 3) {
            return 4;
        }
        int[] count = new int[n];
        count[0] = 1;
        count[1] = 2;
        count[2] = 4;
        for (int i = 3; i < n; i++) {
            count[i] = 0;
            for (int j = 1; j <= m ; j++) {
                count[i] += count[i-j];
            }
        }
        return count[n-1];
    }
    public static int countStairs(int n) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }

        if(n == 3) {
            return 4;
        }

        int oneStep = 1;
        int twoStep = 2;
        int threeStep = 4;
        int curr = 0;
        for (int i = 4; i <= n; i++) {   
             curr = oneStep+twoStep+threeStep;
             oneStep = twoStep;
             twoStep = threeStep;
             threeStep = curr;
        }
        return curr;
    }

    // A recursive function used by countWays till m
    int countWaysUtil(int n, int m)
    {
        int[] res = new int[n];
        res[0] = 1; res[1] = 1;
        for (int i=2; i<n; i++)
        {
            res[i] = 0;
            for (int j=1; j<=m && j<=i; j++)
                res[i] += res[i-j];
        }
        return res[n-1];
    }

    // Returns number of ways to reach s'th stair
    int countWays(int s, int m)
    {
        return countWaysUtil(s+1, m);
    }
    // 0(1) space stair climbing using fibonacci

    public static void main(String[] args) {
            System.out.println(countStairsWays(7));
        int n = 7;
       //StepsPossiblePathsRecur s = new StepsPossiblePathsRecur();
        //int[] dyn = new int[n + 1];
       // System.out.println(possibleWays(n, dyn));
        System.out.println(countStairs(7));
        System.out.println(countStairsMWays(7,2));
    }
}
