package DP;

/**
 * Created by archithrapaka on 4/18/17.
 */
public class LongestCommonSubSequence {

    // recursive 0(2^n)
    public static String findLCS(String x, String y) {

        if (x == null || y == null || x.length() <= 0 || y.length() <= 0) {
            return "";
        }

        int m = x.length();
        int n = y.length();

        if (x.charAt(m - 1) == y.charAt(n - 1)) {
            return x.charAt(m - 1) + findLCS(x.substring(0, m - 1), y.substring(0, n - 1));
        } else {

            String M = findLCS(x, y.substring(0, n - 1));
            String N = findLCS(x.substring(0, m - 1), y);

            return M.length() > N.length() ? M : N;

        }

    }

    public static String findLcsDP(String x, String y) {
        if (x == null || y == null || x.length() <= 0 || y.length() <= 0) {
            return "";
        }

        int m = x.length();
        int n = y.length();
        String[][] sol = new String[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            sol[i][0] = "";
        }

        for (int j = 0; j <= n; j++) {
            sol[0][j] = "";
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    sol[i][j] = sol[i - 1][j - 1] + x.charAt(i - 1);
                } else {
                    String M = sol[i - 1][j];
                    String N = sol[i][j - 1];
                    sol[i][j] = (M.length() > N.length()) ? M : N;
                }
            }
        }
        return sol[m][n];
    }

    public static void main(String[] args) {
        String x = "abbabbbf";
        String y = "abcadf";
        // System.out.println(findLCS(x,y));
        System.out.println(findLcsDP(x, y));
    }
}
