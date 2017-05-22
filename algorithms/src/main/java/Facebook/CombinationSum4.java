package Facebook;

/**
 * Created by archithrapaka on 4/22/17.
 * Kind of a coin sum problem variation
 * given an array of numbers , target sum find number of ways to do it
 */
public class CombinationSum4 {

    public static int findWays(int[] a , int target) {
        int[] dp = new int[target+1];

        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < a.length; j++) {

                    if(i - a[j] >= 0) {
                        dp[i] += dp[i-a[j]];
                    }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        int target = 5;
        System.out.print(findWays(a,target));
    }
}
