package datastrutures.backtracking;

/**
 * Created by archithrapaka on 2/25/17.
 * Given a 2D gird of letters , search for a word
 * Backtrack
 */
public class SearchAword {
    static int path = 1;

    static int xDirection[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int yDirection[] = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static boolean isValid(char[][] mat , int x , int y , int[][] sol) {
        return (x >= 0 && x < mat.length && y >= 0 && y < mat.length && sol[x][y]!= 0);
    }

    public static boolean isValid(int row , int col , boolean[][] visited, int N) {
        return (row >= 0 && row < N && col >= 0 && col < N && !visited[row][col]);
    }

    static void print(int[][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(" " +a[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean searchDfs(char[][] matrix , String word) {
        int N = matrix.length;
        boolean[][] visited = new boolean[N][N];
        String paths = "";
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                 if(matrix[i][j] == word.charAt(0)) {
                     if(searchDfs(matrix,i,j,visited,word,0,"")) {
                      return true;
                     }
                 }
            }
        }
        return true;
    }

    private static boolean searchDfs(char[][] matrix, int row, int col, boolean[][] visited, String word, int index,String paths) {
              if(index == word.length()-1){
                  paths += "("+row+","+col+")";
                  System.out.println(paths);
                  return true;
              }

              if(word.charAt(index) != matrix[row][col]) {
                  return false;
              }

              visited[row][col] = true;
             paths += "("+row+","+col+")";

        for (int k = 0; k < 8; ++k) {
              if(isValid(row+xDirection[k],col+yDirection[k],visited,matrix.length)) {
                  searchDfs(matrix,row+xDirection[k],col+yDirection[k],visited,word,index+1,paths);
              }
        }
        return false;
    }

    public static boolean searchWord(char[][] matrix , String word) {
        int N = matrix.length;
        int[][] sol = new int[matrix.length][matrix.length];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                 if(search(matrix,i,j,word,0,sol,N)) {
                     print(sol);
                     return true;
                 }
            }
        }
        return false;
    }

    public static boolean search(char[][] mat , int x , int y , String target , int index , int[][] sol , int N) {

        if(mat[x][y] != target.charAt(index)) {
            return false;
        }

         if(index == target.length()-1) {
               sol[x][y] = path++;
               return true;
         }


         // set the current path variable to set the path
        sol[x][y] = path++;

           // search bottom
            if(x+1 < N && search(mat,x+1,y,target,index+1,sol,N)) {
                return true;
            }

            // search up
        if(x-1 >=0 && search(mat,x-1,y,target,index+1,sol,N)) {
            return true;
        }
         // search right
        if(y+1 < N && search(mat,x,y+1,target,index+1,sol,N)) {
            return true;
        }

        //search left
        if(y-1 >=0 && search(mat,x,y-1,target,index+1,sol,N)) {
            return true;
        }

        //search forward right diagonally
        if(x+1 < N && y+1 < N && search(mat,x+1,y+1,target,index+1,sol,N)) {
            return true;
        }

        // upper right diagonally
        if(x-1 >=0 && y+1 < N && search(mat,x-1,y+1,target,index+1,sol,N)) {
            return true;
        }
        // diagonally up left
        if( x-1>=0 &&y-1>=0 &&search(mat,x-1,y-1,target,index+1,sol,N)) {
            return true;
        }

        // lower left digonally
        if(x+1<N && y-1 >= 0 && search(mat,x+1,y-1,target,index+1,sol,N)) {
            return true;
        }

        // it has not found solution from current x ,y so backtrack
        sol[x][y] = 0;
          path--;
          return false;
    }



    public static void main(String[] args) {
        char[][] matrix = {  { 't', 'z', 'x', 'c', 'd' },
                             { 'a', 'h', 'n', 'z', 'x' },
                             { 'h', 'w', 'o', 'i', 'o' },
                             { 'o', 'r', 'n', 'r', 'n' },
                             { 'a', 'b', 'r', 'i', 'n' } };

        //searchWord(matrix,"horizon");
             searchDfs(matrix,"horizon");
    }
}
