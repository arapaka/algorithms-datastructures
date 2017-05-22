package Facebook;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by archithrapaka on 4/29/17.
 */
public class WordSearch {

    public static boolean search(char[][] grid , String s) {
        String sub = "";
        char[] w = s.toCharArray();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == s.charAt(0)) {
                    if(dfs(grid,i,j,sub,s,visited,w,0)) {
                        return true;
                    };
                }
            }
        }
        return false;
    }

    public static boolean searchBfs(char[][] grid , String s) {
        String sub = "";
        char[] w = s.toCharArray();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == s.charAt(0)) {
                     if(bfs(grid,i,j,sub,s,w,visited,1)) {
                         return true;
                     }
                }
            }
        }

      return false;
    }

    static class Cordinate {
        int x;
        int y;
        public Cordinate(int x , int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static boolean bfs(char[][] grid, int i, int j, String sub, String s, char[] w, boolean[][] visited,int index) {
        Queue<Cordinate> queue = new LinkedList<>();
        queue.add(new Cordinate(i,j));

        while (!queue.isEmpty()) {

               if(index == s.length()) {
                   System.out.print(sub);
                   return true;
               }
                Cordinate current = queue.poll();
               sub += "("+current.x+","+current.y+")";
               visited[current.x][current.y] = true;

               if(isValid(grid, current.x, current.y+1, visited, w, index)) {
                    queue.add(new Cordinate(current.x,current.y+1));
                    index++;
                }

            if(isValid(grid, current.x+1, current.y, visited, w, index)) {
                queue.add(new Cordinate(current.x+1,current.y));
                index++;
            }

            if(isValid(grid, current.x, current.y-1, visited, w, index)) {
                queue.add(new Cordinate(current.x,current.y-1));
                index++;
            }

            if(isValid(grid, current.x-1, current.y, visited, w, index)) {
                queue.add(new Cordinate(current.x-1,current.y));
                index++;
            }

        }
        return false;
    }


    private static boolean dfs(char[][] grid, int i, int j, String sub, String target,boolean[][] visited,char[] w , int index) {

        if(index == target.length()) {
            System.out.print(sub);
            return true;
        }

        if(!isValid(grid,i,j,visited,w,index)) {
            return false;
        }
        sub += "("+i+","+j+")";
        visited[i][j] = true;
       boolean exist =  dfs(grid,i,j+1,sub,target,visited,w,index+1)||
        dfs(grid,i+1,j,sub,target,visited,w,index+1)||
        dfs(grid,i,j-1,sub,target,visited,w,index+1)||
        dfs(grid,i-1,j,sub,target,visited,w,index+1);
       return exist;

    }

    private static boolean isValid(char[][] grid, int i, int j,boolean[][] visited,char[] w,int index) {
        return (i >=0 && i < grid.length)
                && (j >=0 && j < grid[0].length)
                && !visited[i][j] && index < w.length && w[index]==grid[i][j];
    }

    public static void main(String[] args){
        String s = "ABFD";
        char[][] a = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        //System.out.print(search(a,s));
        System.out.print(searchBfs(a,s));
    }
}
