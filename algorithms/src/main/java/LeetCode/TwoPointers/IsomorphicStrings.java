package LeetCode.TwoPointers;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by archithrapaka on 4/7/17.
 */
public class IsomorphicStrings {

    public static boolean checkIsomorphic(String a , String other) {
        // check for null inputs
        if (null == a && other != null  || a != null && null == other) {
            return false;
        }
// check for lengths
        if(a.length() != other.length() ) {
            return false;
        }
        Map<Character,Character> map = new HashMap<>();
        int length = a.length();
        int count = 0;
        while(count < length) {
            char c1 = a.charAt(count); // char for first string
            char c2 = other.charAt(count); // char for second string

            if ( map.containsKey(c1 )  )
            {
                if (map.get(c1) != c2 ) {
                return false;
            }
            }
// check if the value is already mapped
            else {
                if( map.containsValue(c2) ) {
                    return false;
                }
            }
            map.put(c1,c2); // map c1 to c2;
            count++;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
