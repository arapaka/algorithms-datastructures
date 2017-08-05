package tutorialHorizon.arrays;

/**
 * Created by archithrapaka on 7/18/17.
 */
public class CountAllPathsFromTopLeft {

    public static int countPaths(int[][] a) {
        return countPaths(0,0,a,"",0);
    }

    /**
     * Exponential path
     * @param row
     * @param column
     * @param a
     * @param path
     * @param count
     * @return
     */
    private static int countPaths(int row, int column, int[][] a , String path,int count) {
         if(row == a.length-1) {
//             for (int i = column; i < a[0].length; i++) {
//                 path += "->" + a[row][i];
//             }
//             count +=1;
//             return count;
             return 1;
         }
         if (column == a[0].length-1) {
//             for (int i = row; i < a.length; i++) {
//                 path += "->" + a[i][column];
//             }
//             count += 1;
//             return count;
             return 1;
         }
         path += "->" + a[row][column];

         return countPaths(row+1,column,a,path,count) +
                countPaths(row,column+1,a,path,count) +
                 countPaths(row+1,column+1,a,path,count);
    }

    //Dynamic programming version

   private static int countPathsDp(int[][]a) {
       int[][] dp = new int[a.length][a[0].length];

        for (int i = 0; i < a[0].length; i++) {
             dp[0][i] = 1;
       }
       for (int i = 0; i < a.length; i++) {
           dp[i][0] = 1;
       }
       for (int i = 1; i < a.length; i++) {
           for (int j = 1; j < a[0].length; j++) {
               dp[i][j] = dp[i][j-1] + dp[i-1][j] + dp[i-1][j-1];
           }
       }
       return dp[a.length-1][a[0].length-1];
   }

    public static void main(String[] args) {
        int[][] a = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        System.out.println(countPaths(a));
        System.out.println(countPathsDp(a));
    }
}
