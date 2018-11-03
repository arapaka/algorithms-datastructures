package codefights;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by archithrapaka on 5/16/17.
 */
public class FirstNonRepeatingChar {

    static char getFirstNonRepeatingChar(String s) {

        Map<Character, CharIndex> map = new HashMap<>(26);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = i;
            int count = 1;
            CharIndex charIndex = new CharIndex(count, index);

            if (map.containsKey(c)) {
                charIndex = map.get(c);
                charIndex.count = charIndex.count + 1;
                map.put(c, charIndex);
            } else {
                map.put(c, charIndex);
            }
        }

        int min = Integer.MAX_VALUE;
        for (char c : map.keySet()) {
            if (map.get(c).count > 1) {
                continue;
            } else {
                if (map.get(c).index < min) {
                    min = map.get(c).index;
                }
            }
        }
        if (min == Integer.MAX_VALUE) {
            return '_';
        }
        return s.charAt(min);
    }

    static class CharIndex {
        int count;
        int index;

        public CharIndex(int count, int index) {
            this.count = count;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        String s = "abacabad";
        System.out.println(getFirstNonRepeatingChar(s));
        System.out.println(getFirstNonRepeatingChar("abacabaabacaba"));
    }
}
