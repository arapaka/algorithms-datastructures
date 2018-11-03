package Facebook;

/**
 * Created by archithrapaka on 4/29/17.
 */
public class WallsAndGates {

    public static void walls(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    dfs(grid, i, j, 0);
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isValid(int[][] grid, int i, int j, int distance) {
        return (i >= 0 && i < grid.length) && (j >= 0 && j < grid[0].length &&
                grid[i][j] >= distance);
    }

    private static void dfs(int[][] grid, int i, int j, int distance) {
        if (!isValid(grid, i, j, distance)) return;

        grid[i][j] = distance;

        dfs(grid, i, j + 1, distance + 1);
        dfs(grid, i + 1, j, distance + 1);
        dfs(grid, i, j - 1, distance + 1);
        dfs(grid, i - 1, j, distance + 1);
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{Integer.MAX_VALUE - 3, -1, 0, Integer.MAX_VALUE - 3},
                {Integer.MAX_VALUE - 3, Integer.MAX_VALUE - 3, Integer.MAX_VALUE - 3, -1},
                {Integer.MAX_VALUE - 3, -1, Integer.MAX_VALUE - 3, -1},
                {0, -1, Integer.MAX_VALUE - 3, Integer.MAX_VALUE - 3}};
        walls(a);
    }
}
