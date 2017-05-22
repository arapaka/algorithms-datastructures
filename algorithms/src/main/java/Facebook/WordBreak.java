package Facebook;

import java.util.*;

/**
 * Created by archithrapaka on 4/29/17.
 */
public class WordBreak {

    // cannot be used to test single word multiple times like
    public static boolean wordBreak(List<String> dict , String s) {
        boolean[] dp = new boolean[s.length()];
        Map<String,Boolean> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
                sb.append(s.charAt(i));
               if(dict.contains(sb.toString()) && !map.containsKey(sb.toString())) {
                   dp[i] = true;
                   map.put(sb.toString(),true);
                   sb.setLength(0);
               }
        }
        return dp[s.length()-1];
    }

    public static boolean wordBreak(String s, Set<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];

        List<String> words = new ArrayList<>();

        dp[0] = true;

        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {

                if(dp[j] && wordDict.contains(s.substring(j, i))) {

                    dp[i] = true;
                    words.add(s.substring(j,i));
                    break;
                }

            }

        }
        for (String word:words) {
            System.out.println(word + " , ");
        }
        return dp[s.length()];
    }
    public static void main(String[] args){
            List<String> list = new ArrayList<>();
            list.add("am");
        list.add("i");
        list.add("done");
        list.add("in");
        list.add("here");
        Set<String> set = new HashSet<>(list);

        String s = "iaminheredone";
        //System.out.print(wordBreak(list,s));
        System.out.println(wordBreak(s,set));
    }
}
