package datastrutures.backtracking;

/**
 * Created by archithrapaka on 2/22/17.
 */
public class KnightsTour {
    static final int N = 10;

    public static boolean validMove(int[][] sol, int x, int y) {
        return (x >= 0 && x < N) && (y >= 0 && y < N) && sol[x][y] == 0;
    }

    static void printSol(int[][] sol) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(sol[i][j]);
            }
            System.out.println();
        }
    }

    static boolean knightsTour() {
        int sol[][] = new int[N][N];

        // initialize
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sol[i][j] = 0;
            }
        }

        int[] xMove = {2, 1, -1, -2, -1, -2, 1, 2};
        int[] yMove = {1, 2, 2, 1, -2, -1, -2, -1};

        if (solveKt(0, 0, 1, sol, xMove, yMove)) {
            printSol(sol);
            return true;
        }
        System.out.println("No solution exists");
        return false;
    }

    private static boolean solveKt(int x, int y, int movei, int[][] sol, int[] xMove, int[] yMove) {
        int k, nextX, nextY;

        if (movei == N * N) {
            return true;
        }

        /**
         * try all moves from current cordinate
         */
        for (k = 0; k < 8; k++) {
            nextX = x + xMove[k];
            nextY = y + yMove[y];

            if (validMove(sol, nextX, nextY)) {
                sol[nextX][nextY] = movei;

                if (solveKt(nextX, nextY, movei + 1, sol, xMove, yMove)) {
                    return true;
                }
                // backtrack
                else {
                    sol[nextX][nextY] = 0;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        knightsTour();
    }

}
