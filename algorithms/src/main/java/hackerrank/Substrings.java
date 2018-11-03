package hackerrank;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by archithrapaka on 6/6/17.
 */
public class Substrings {

    public static void print(String s) {

        Set<String> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                System.out.println(s.substring(i, j + 1));
                if (!set.contains(s.substring(i, j + 1))) {
                    count++;
                    set.add(s.substring(i, j + 1));
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        String s = "abaa";
        print(s);
    }
}
