package LeetCode.strings;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> list = new ArrayList<>();
        int i = 0;
        int pKey = getKey(p);

        while (i < s.length() - p.length() + 1) {
            String sub = s.substring(i, i + p.length());
            if (getKey(sub) == pKey) {
                list.add(i);
            }
            i++;
        }
        return list;
    }

    public static int getKey(String p) {
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};

        int key = 1;
        for (char c : p.toCharArray()) {
            key *= prime[c - 'a'];
        }
        return key;
    }

    public static void main(String[] args) {
        String s = "aaa";
        String p = "a";
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "ab";
        System.out.println(s);
    }
}
