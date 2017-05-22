package datastrutures.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by archithrapaka on 3/19/17.
 */
public class IsomorphicStrings {

    public static Boolean isIsomorphic(String s , String t) {

        if(s == null || t == null) {
            return false;
        }
        if(s.length() != t.length()) {
            return false;
        }

        int n = s.length();
        int i = 0;
        Map<Character,Character> map = new HashMap<>();
        while (i < n) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

             // if mapping from c1 to c2 is not correct return false;
             if(map.containsKey(c1)) {
                 if(c2 != map.get(c1)) {
                     return false;
                 }
             }

             if(map.containsValue(c2)) {
                 return false;
             }

            map.put(c1,c2);
        }
        return true;
    }

    public static void main(String[] args){

    }
}
