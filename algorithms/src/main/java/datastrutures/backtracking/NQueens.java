package datastrutures.backtracking;

/**
 * Created by archithrapaka on 2/23/17.
 */
public class NQueens {
    static final int N = 4;

    /**
     * prints the solution board
     *
     * @param board
     */
    public static void print(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * CHECK IF THE MOVE IS VALID ,
     *
     * @param board
     * @param row
     * @param col
     * @return
     */
    static boolean isValid(int[][] board, int row, int col) {
        int i, j;
        // check the row
        for (i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // upper left diagonal
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // lower left diagonal
        for (i = row, j = col; j >= 0 && i < N; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    static boolean solveNQ(int[][] board, int col) {
        // base case if all cols have been used
        if (col >= N) {
            return true;
        }

        // consider for this col
        for (int i = 0; i < N; i++) {

            if (isValid(board, i, col)) {
                // place queen on the board and mark it
                board[i][col] = 1;

                // recur to place the rest of queens

                if (solveNQ(board, col + 1)) {
                    return true;
                } else {
                    // unmark that move set board[i][col] = 0
                    board[i][col] = 0; //BACKTRACK
                }
            }
        }
        return false;
    }

    static void solveNqueen() {
        int board[][] = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        if (solveNQ(board, 0)) {
            print(board);
        } else {
            System.out.println("Solution does not exist !");
        }
    }

    public static void main(String[] args) {
        solveNqueen();
    }
}
