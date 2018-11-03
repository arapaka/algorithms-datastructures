package datastrutures.graphs;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by archithrapaka on 2/26/17.
 * Directed Acyclic graph
 */
public class TopologicalSorting {
    DiGraph diGraph;

    public TopologicalSorting(int v) {
        this.diGraph = new DiGraph(v);
    }

    private class DiGraph {
        private int V;
        private LinkedList<Integer>[] adj;

        public DiGraph(int v) {
            this.V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < V; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        void addEdge(int u, int v) {
            adj[u].add(v);  // add v to adjacent's list
        }
    }

    void TSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;

        for (int w : diGraph.adj[v]) {
            if (!visited[w]) {
                TSortUtil(w, visited, stack);
            }
        }
        stack.push(v);
    }

    void TSort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[this.diGraph.V];

        for (int i = 0; i < this.diGraph.V; i++) {
            if (!visited[i]) {
                TSortUtil(i, visited, stack);
            }
        }
        System.out.println("Topological sorting order !");

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " -->");
        }
    }

    public static void main(String[] args) {
        TopologicalSorting topologicalSorting = new TopologicalSorting(6);


        topologicalSorting.diGraph.addEdge(5, 2);
        topologicalSorting.diGraph.addEdge(5, 0);
        topologicalSorting.diGraph.addEdge(4, 0);
        topologicalSorting.diGraph.addEdge(4, 1);
        topologicalSorting.diGraph.addEdge(2, 3);
        topologicalSorting.diGraph.addEdge(3, 1);
        topologicalSorting.TSort();
    }
}
