package Facebook;

/**
 * Created by archithrapaka on 5/2/17.
 */
public class PossibleSubsets {

    public static void print(int n , String x) {
        if(n == 0) {
            System.out.println(x);
            return;
        }
        else {

            for (int i = 1; i <= n; i++) {
                 x = x+i;
                 print(n-i,x);
                 x = x.substring(0,x.length()-1);
            }

        }
    }
}
