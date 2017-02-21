package datastrutures.backtracking;

/**
 * Created by archithrapaka on 2/21/17.
 */
public class RatInAMaze {

    static void print(int[][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                 System.out.print(" " +a[i][j]);
            }
            System.out.println();
        }
    }

    static boolean isValidMove(int[][] maze, int x , int y , int N) {
        return (x >= 0 && y >= 0  && x < N && y < N && maze[x][y] == 1);
    }

    static boolean solveMaze(int[][] maze){

        int[][] sol = new int[maze.length][maze.length];

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                   sol[i][j] = 0;
            }
        }

        if(findPath(maze,0,0,sol)) {
            print(sol);
            return true;
        }
        else {
            System.out.print("no solution exists!");
            return false;
        }
    }

    static boolean  findPath(int[][] maze,int x , int y, int[][] sol) {

        int N = maze.length;
        /**
         * final block reached , add the cell to sol and return true
         */
        if(x == N-1 && y == N-1) {
              sol[x][y] = 1;
              return true;
          }

          // check if it is a valid move , if yes add it to the sol
          if(isValidMove(maze,x,y,N)) {

            // add the solution cell
               sol[x][y] = 1;


               /*move in the y direction to find a sol*/
              if (findPath(maze,x,y+1,sol)) {
                  return true;
              }

               /*move forward in the X direction*/
               if(findPath(maze,x+1,y,sol)){
                   return true;
               }



              /*move in the upper direction to find a sol*/
              if (findPath(maze,x-1,y,sol)) {
                  return true;
              }
              /*move in the left direction to find a sol*/
              if (findPath(maze,x,y-1,sol)) {
                  return true;
              }

              /*none of the above moves worked * so , backtrack/
               remove the solution cell and make it 0
               */
              sol[x][y] = 0;
              return false;
          }
          // return false otherwise
        return false;
    }

    public static void main(String[] args) {
        int maze[][] = {{1, 1, 1, 1},
                {1, 1, 0, 1},
                {0, 1, 0, 1},
                {1, 1, 1, 1}
        };
        solveMaze(maze);
    }
}
