package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};

        List<List<String>> list = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (String s : strs) {
            int key = 1;
            for (char c : s.toCharArray()) {
                key *= prime[c - 'a'];
            }
            List<String> subList;
            if (map.containsKey(key)) {
                subList = list.get(map.get(key));
            } else {
                subList = new ArrayList<>();
                list.add(subList);
                map.put(key, list.size() - 1);
            }
            subList.add(s);
        }

        return list;
    }

//    public static int[] getPrimes(int Number){
//        List<Integer> integers = new ArrayList<>();
//        for (int i = 2; i < Number; i++) {
//             if(isPrime(i)) {
//                 integers.add(i);
//             }
//        }
//
//    }

}
