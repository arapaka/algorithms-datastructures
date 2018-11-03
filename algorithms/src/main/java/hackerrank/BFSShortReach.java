package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by archithrapaka on 4/9/17.
 */
public class BFSShortReach {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int q = Integer.parseInt(bufferedReader.readLine());

            while (q > 0) {
                String firstLine = bufferedReader.readLine();

                int n = Integer.parseInt(firstLine.split(" ")[0]);
                int m = Integer.parseInt(firstLine.split(" ")[1]);
                Map<Integer, List<Integer>> map = new HashMap<>(); // node and list of adjacent nodes;

                while (m > 0) {
                    String secondLine = bufferedReader.readLine();
                    int A = Integer.parseInt(secondLine.split(" ")[0]);
                    int B = Integer.parseInt(secondLine.split(" ")[1]);

                    if (map.containsKey(A)) {
                        map.get(A).add(B);
                    } else {
                        List<Integer> newList = new ArrayList<>();
                        newList.add(B);
                        map.put(A, newList);
                    }
                    m--;
                }
                int firstNode = Integer.parseInt(bufferedReader.readLine());
                printBFS(firstNode, map);
                System.out.println();
                q--;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printBFS(int firstNode, Map<Integer, List<Integer>> map) {
        Queue<Integer> q = new LinkedList<>();
        q.add(firstNode);

        while (!q.isEmpty()) {
            Integer first = q.poll();
            System.out.print(first + " -->");
            if (map.containsKey(first)) {
                List<Integer> neighbours = map.get(first);
                q.addAll(neighbours);
            }
        }
    }

}
