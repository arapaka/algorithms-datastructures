package datastrutures.linkedlists.gaylelaakman;

import java.util.*;

/**
 * Created by archithrapaka on 2/5/17.
 */
public class RemoveDups {

    public static List<List<String>> groupAnagrams(String[] strs) {
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};

        List<List<String>> list = new ArrayList<>();
        List<String> subList;
        Map<Integer, Integer> map = new HashMap<>();

        for (String s : strs) {
            int key = 1;
            for (char c : s.toCharArray()) {
                key *= prime[c - 'a'];
            }

            if (map.containsKey(key)) {
                subList = list.get(map.get(key));
            } else {
                subList = new ArrayList<>();
                subList.add(s);
                map.put(key, subList.size() - 1);
            }

        }
        return list;
    }

//    public static boolean isAnagram(String var1 , String var2) {
//
//    }

    public static void main(String[] args) {
        String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
        //System.out.println(groupAnagrams(s));
    }
}
