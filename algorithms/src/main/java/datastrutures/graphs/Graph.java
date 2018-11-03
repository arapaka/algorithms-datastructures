package datastrutures.graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by archithrapaka on 2/26/17.
 * Directed Graph
 */
public class Graph {

    public int V; // no of vertices
    public LinkedList<Integer>[] adj;

    //constructor
    public Graph(int v) {
        this.V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // function to add an edge

    public void addEdge(int v, int w) {
        adj[v].add(w); // add w to v's linked list
        adj[w].add(v);
    }

    // recursive DFS
    void DFSUtil(int v, boolean[] visited) {
        if (visited[v]) {
            return;
        }
        visited[v] = true;
        System.out.print(v + "->");
        // iterate adjacent items to thsi vertex
        Iterator<Integer> items = adj[v].listIterator();

        while (items.hasNext()) {
            int n = items.next();

            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    // dfs from specific vertex
    void DFS(int v) {
        boolean[] visited = new boolean[V];
        DFSUtil(v, visited);
    }


    void DFS() {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            DFSUtil(i, visited);
        }

    }

    //BFS
    public void BFS(int s) {
        boolean[] visited = new boolean[V];
        // mark visited true
        visited[s] = true;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(s);

        while (!queue.isEmpty()) {
            Integer item = queue.poll();
            System.out.print(item + " -->");
            Iterator<Integer> list = adj[item].listIterator();

            while (list.hasNext()) {
                Integer next = list.next();
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }

    public void BfsPathExists(int start, int target) {
        boolean[] visited = new boolean[V];
        // mark visited true
        visited[start] = true;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        List<Integer> path = new ArrayList<>();

        while (!queue.isEmpty()) {
            Integer item = queue.poll();
            path.add(item); // add to the path
            if (item == target) {
                break;
            }
            Iterator<Integer> list = adj[item].listIterator();

            while (list.hasNext()) {
                Integer next = list.next();
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        if (visited[target]) {
            for (Integer i : path) {
                System.out.print(i + " -->");
            }
        }
    }

    void BFS() {
        boolean[] visited = new boolean[V];

        // BFS from all vertices
        for (int i = 0; i < V; i++) {
            BFS(i);
            System.out.println();
        }
    }

    boolean pathExists(int a, int b) {
        //
        boolean[] visited = new boolean[V];
        DFSUtil(a, visited);
        return visited[b];
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        //g.addEdge(2, 3);
        g.addEdge(3, 3);

        //g.DFS();
        System.out.println(g.pathExists(0, 3));
        //g.BFS(2);
        //g.BFS();
    }
}
