package datastrutures.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by archithrapaka on 3/5/17.
 */
public class TopologicalSortingGeneral<K> {
    Digraph<K> digraph;


//    public TopologicalSortingGeneral(int v) {
//        this.digraph = new Digraph<K>(v);
//    }

    public TopologicalSortingGeneral(Digraph<K> digraph) {
        this.digraph = digraph;
    }

    private static class Digraph<K> {
        private ArrayList<K> vertices; // vertices array
        private LinkedList<K>[] adj; // adjacency lists

        public Digraph(int v , ArrayList<K> vertices){
            this.vertices = vertices; // cannot instantiate the type parameter directly
            adj = new LinkedList[v];

            // iterate the vertices
            for (int i = 0;i < v;i++) {
                adj[i] = new LinkedList<K>();
            }
        }

        void addEdge(K u , K v) {
            //adj[u].add(v);
            int index = vertices.indexOf(u); // get the index of Kth Object

            adj[index].add(v);
        }
    }

    void TSortUtil(int v , boolean[] visited , Stack<K> stack) {
        visited[v] = true;

        for (K k:digraph.adj[v]) {
              int index = digraph.vertices.indexOf(k);
              if(!visited[index]) {
                  TSortUtil(index,visited,stack);
              }
        }
        stack.push(this.digraph.vertices.get(v));
    }

    void TSort() {
        boolean[] visited = new boolean[digraph.vertices.size()];
        Stack<K> stack = new Stack<K>();
         ArrayList<K> vertices = this.digraph.vertices;

        for (int i = 0; i < vertices.size(); i++) {
              if(!visited[i]) {
                  TSortUtil(i,visited,stack);
              }
        }
        System.out.println("Topological sorting order !");

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " -->");
        }
    }

    public static void main(String[] args) {

          String[] vertices = new String[]{"NYC","SFO","STL","HYD","BGL","SEA"};
           ArrayList<String> verticesList = new ArrayList<>(Arrays.asList(vertices));

           Digraph<String> digraph = new Digraph<String>(6, verticesList);
           digraph.addEdge("SEA","STL");
        digraph.addEdge("SEA","NYC");
        digraph.addEdge("BGL","NYC");
        digraph.addEdge("BGL","SFO");
        digraph.addEdge("STL","HYD");
        digraph.addEdge("HYD","SFO");
        TopologicalSortingGeneral<String> topologicalSorting = new TopologicalSortingGeneral(digraph);
        topologicalSorting.TSort();

    }
}
