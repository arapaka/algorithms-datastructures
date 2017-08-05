package tutorialHorizon.arrays;

import java.util.*;

/**
 * Created by archithrapaka on 7/5/17.
 */
public final class PrintAllPathsFromTopLeft {

    public static void printPaths(int[][] a) {
        boolean[][] visited = new boolean[a.length][a[0].length];
        String paths = "";
        findPaths(0,0,a,visited,paths);
        //displayPaths(paths);
    }


    public static boolean isValid(int x , int y , int[][] a) {
        return (x >= 0 && x < a.length) && (y >= 0 && y < a[0].length);
    }

    public static void findPaths(int x , int y , int[][] a , boolean[][] b ,String paths) {

        if(x == a.length-1 ) {
            for (int i = y; i <= a[0].length-1; i++) {
                paths += "->"+ ("("+a[x][i]+")");
            }
            System.out.println(paths);
            //paths.setLength(0);
            return;
        }

        if(y == a[0].length-1) {
            for (int j = x; j <= a.length-1; j++) {
                paths += "->"+("("+a[j][y]+")");
            }
            System.out.println(paths.toString());
            //paths.setLength(0);
            return;
        }


        paths += "->"+("("+a[x][y]+")");

             findPaths(x+1,y,a,b,paths);
             findPaths(x,y+1,a,b,paths);


    }

    public static void main(String[] args) throws Exception {
        int[][] a = { { 1, 2, 3 },
                      { 4, 5, 6 },
                      { 7, 8, 9 } };
        printPaths(a);
        Set<Integer> set = new HashSet<Integer>();
        Iterator<Integer> iterator = set.iterator();
        int i = 0;
    }

}
