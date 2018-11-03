package LeetCode.TwoPointers;

import datastrutures.graphs.Graph;

import java.util.*;

/**
 * Created by archithrapaka on 4/7/17.
 * Given words exist in dictionary
 * you just add edges that differ by one characer and do a bfs from start
 */

public class WordLadder {

    public static void wordLadder(List<String> dict, String start, String end) {
        dict.add(start);
        dict.add(end);
        Graph graph = new Graph(dict.size());
        for (String word1 : dict) {
            for (String word2 : dict) {
                if (word1.compareTo(word2) < 0 && differByoneChar(word1, word2)) {
                    graph.addEdge(dict.indexOf(word1), dict.indexOf(word2));
                }
            }
        }
        graph.BfsPathExists(dict.indexOf(start), dict.indexOf(end));
    }

    //
    public static boolean differByoneChar(String a, String b) {
        assert a.length() == b.length();
        int differ = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                differ++;
            }
            if (differ > 1) return false;

        }
        return true;
    }

    public static void main(String[] args) {
        String[] s = new String[]{"hot", "dot", "dog", "lot", "log"};
        List<String> list = new ArrayList<>(Arrays.asList(s));
        wordLadder(list, "hit", "lot");
        //print("hit",list);
        Set<String> dict = new HashSet<>();

        for (String s1 : s) {
            dict.add(s1);
        }
        //wordLadder("hit","cog",list);
        //System.out.println(ladderLength2("hit","cog",dict));
    }
}
