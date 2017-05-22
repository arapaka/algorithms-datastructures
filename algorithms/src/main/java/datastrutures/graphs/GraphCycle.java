package datastrutures.graphs;

import java.util.Stack;

/**
 * Created by archithrapaka on 2/26/17.
 * detect a cycle in Directed Graph
 */
public class GraphCycle {

    private Stack<Integer> cycle;
    private int[] edgeTo;

//    public GraphCycle(Graph g) {
//
//    }

    boolean isCyclic(Graph graph) {
        boolean[] visited = new boolean[graph.V]; // visited vertices
        boolean[] recStack = new boolean[graph.V]; // current vertices on the stack
        edgeTo = new int[graph.V];

        for (int v= 0; v < graph.V;v++) {
             if(!visited[v]) {
                 if(DFS(v,visited,recStack,graph,edgeTo)) {
                     return true;
                 }
             }
        }
        return false;
    }

    private boolean DFS(int v, boolean[] visited, boolean[] recStack,Graph graph,int[] edgeTo) {
           visited[v] = true;
           recStack[v] = true;

        for (Integer w:graph.adj[v]) {
              if(this.hasCycle()) {
                  return true;
              }

             else if(!visited[w]) {
                  edgeTo[w] = v;
                 DFS(w,visited,recStack,graph,edgeTo);
             } else if (recStack[w]) {
                  // return true or construct a cycle object
                  cycle = new Stack<Integer>();
                  for (int x = v; x != w; x = edgeTo[x]) {
                      cycle.push(x);
                  }
                  cycle.push(w);
                  cycle.push(v);
              }
        }
        recStack[v] = false;
        return false;
    }

    public boolean hasCycle() {
        return cycle != null;
   }

   public static void main(String[] args) {
        Graph g = new Graph(4);
       g.addEdge(0, 1);
       g.addEdge(0, 2);
       g.addEdge(1, 2);
       g.addEdge(2, 0);
       g.addEdge(2, 3);
       g.addEdge(3, 3);

       GraphCycle graphCycle = new GraphCycle();

       System.out.println(graphCycle.isCyclic(g));

       for (Integer i:graphCycle.cycle
            ) {
           System.out.print(i);
       }
   }
}
