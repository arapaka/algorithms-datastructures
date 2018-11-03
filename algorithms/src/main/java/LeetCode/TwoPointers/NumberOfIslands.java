package LeetCode.TwoPointers;

/**
 * Created by archithrapaka on 4/15/17.
 */
public class NumberOfIslands {

    static int[] xWalks = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] yWalks = new int[]{1, 0, -1, 1, 0, 0, 1, 0, -1};

    static boolean isValid(int[][] mat, int x, int y, boolean[][] visited) {
        return (x >= 0 && mat.length > x) && (y >= 0 && y < mat[0].length)
                && (mat[x][y] == 1)
                && (!visited[x][y]);
    }

    public static int DFS(int[][] mat) {
        boolean[][] visited = new boolean[mat.length][];
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (!visited[i][j] && mat[i][j] == 1) {
                    DFSUtil(i, j, mat, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public static void DFSUtil(int x, int y, int[][] mat, boolean[][] visited) {

        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            x += xWalks[i];
            y += yWalks[i];
            if (isValid(mat, x, y, visited)) {
                DFSUtil(x, y, mat, visited);
            }
        }

    }


    public static void main(String[] args) {

    }
}
