package codefights;

import java.util.*;

/**
 * Created by archithrapaka on 5/16/17.
 * find all repeated substrings of length K
 */
public class RepeatedSubtringsLengthK {

    static String[] findRepeatedSubstrings(String s, int k) {

        if (s == null || s.isEmpty()) {
            return new String[]{};
        }

        Map<String, Integer> map = new HashMap<>();
        int limit = s.length() - k + 1;

        for (int i = 0; i < limit; i++) {
            String sub = s.substring(i, i + k);
            Integer counter = map.get(sub);

            if (counter == null) {
                counter = 0;
            }
            map.put(sub, ++counter);
        }

        List<String> list = new ArrayList<>();
        //int index = 0;

        for (String key : map.keySet()) {
            if (map.get(key) > 1) {
                list.add(key);
            }
        }
        String[] keys = new String[list.size()];
        return list.toArray(keys);
    }

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        String[] rep = findRepeatedSubstrings(s, 10);
        for (String string : rep) {
            System.out.print(string + " ");
        }

    }
}
