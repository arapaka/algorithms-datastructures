package datastrutures.strings;

import java.util.*;

/**
 * Created by archithrapaka on 3/11/17.
 */
public class WordBreak {

    public static boolean findUsingDP(String s, HashSet<String> dict,
                                      HashSet<String> memory, String answer) {
        if (s.length() == 0) {
            System.out.println(answer);
            return true;
        } else if (memory.contains(s)) {
            return false;
        } else {
            int index = 0;
            String word = "";
            while (index < s.length()) {
                word += s.charAt(index);// add one char at a time
                // check if word already being solved
                if (dict.contains(word)) {
                    if (findUsingDP(s.substring(index + 1), dict, memory,
                            answer + word + " ")) {
                        return true;
                    } else {
                        System.out.println("backtrack");
                        index++;
                    }
                } else {
                    index++;
                }
            }
            memory.add(s);// memoization for future;
            return false;
        }
    }

    public static boolean wordBreak(String s, Set<String> wordDict) {

        boolean[] dp = new boolean[s.length()];

        dp[0] = true;

        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {

                if (dp[j] && wordDict.contains(s.substring(j, i))) {

                    dp[i] = true;
                    break;

                }

            }

        }

        return dp[s.length() - 1];

    }

    public static void main(String[] args) {
        String[] words = new String[]{"aaaa", "aaa"};
        HashSet<String> hs = new HashSet<String>();
        hs.add("aaaa");
        hs.add("aaa");
        String s = "aaaaaaa";
        HashSet<String> memoization = new HashSet<String>();
        //findUsingDP("aaaaaaa",hs,memoization,"");
        System.out.print(wordBreak(s, hs));
//        Queue<Integer> queue = new Queue<>();
//        while (queue.isEmpty())
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        //words.length
    }
}
