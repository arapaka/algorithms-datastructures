package Facebook;

/**
 * Created by archithrapaka on 4/22/17.
 */
public class CoinChange {

    public static int findMinCoin(int[] coins , int change) {
        int[] table = new int[change+1];
        table[0] = 0; // if given change is 0;

        for (int i = 1; i <=change ; i++) {
            table[i] = Integer.MAX_VALUE-2;
        }
        for (int i = 1; i <= change ; i++) {
            for (int j = 0; j < coins.length; j++) {
                  if(coins[j] <= i) {
                      int sub_res = table[i-coins[j]];
                              if(sub_res +1 < table[i]) {
                                    table[i] = sub_res +1;
                              }
                  }
            }
        }
        return table[change];
    }


    public static void main(String[] args) {
        int[] coins = {9,6,5,1};
        System.out.print(findMinCoin(coins,11));
    }
}
