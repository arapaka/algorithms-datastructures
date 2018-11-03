package practice;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Undirected Generic graph Data Structure.
 * @param <V>
 * @author archithrapaka
 */
public class UnDirectedGraph<V> {
    private Map<V, List<V>> edges;

    public UnDirectedGraph(Map<V, List<V>> edges) {
        this.edges = edges;
    }


    /**
     * Uses the BFS logic to search for a path between two Nodes.
     * @param v1 Node start
     * @param v2 Node destination
     * @return whether the path exists
     */
    public boolean isPathExists(V v1, V v2) {
        return isConnected(v1, v2);
    }

    public boolean isConnected(V v1, V v2) {

        if (!this.edges.containsKey(v1) && !this.edges.containsKey(v2)) {
            return false;
        }

        Queue<V> queue = new LinkedList<>();

        Set<V> seen = new HashSet<>();

        queue.add(v1);

        while (!queue.isEmpty()) {

            V v = queue.poll();

            if (v2.equals(v)) {
                return true;
            }
            seen.add(v);

            List<V> neighbours = edges.get(v);

            if (Objects.nonNull(neighbours) && !neighbours.isEmpty()) {
                List<V> filtered = neighbours.stream()
                        .filter(i -> !seen.contains(i))
                        .collect(Collectors.toList());
                seen.addAll(filtered);
                queue.addAll(filtered);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // List<String> vertices = Arrays.asList("JFK","NYC","SFO","IND");
        Map<String, List<String>> nodes = new HashMap<>();
        nodes.put("JFK", Arrays.asList("NYC", "SFO"));
        nodes.put("NYC", Arrays.asList("IND"));

        UnDirectedGraph<String> unDirectedGraph = new UnDirectedGraph<>(nodes);
        System.out.println(unDirectedGraph.isPathExists("JFK", "IND"));

        Map<Integer,List<Integer>> edges = new HashMap<>();

        edges.put(1,Arrays.asList(3,7,8));
        edges.put(7,Arrays.asList(9,10));
        edges.put(10,Arrays.asList(12));

        UnDirectedGraph<Integer> unDirectedGraph1 = new UnDirectedGraph<>(edges);
        System.out.println(unDirectedGraph1.isPathExists(1,12));
        System.out.println(unDirectedGraph1.isPathExists(7,12));
        System.out.println(unDirectedGraph1.isPathExists(3,12));
    }

}
