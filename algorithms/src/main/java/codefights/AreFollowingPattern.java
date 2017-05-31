package codefights;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by archithrapaka on 5/27/17.
 */
public class AreFollowingPattern {
    boolean areFollowingPatterns(String[] strings, String[] patterns) {

        int i = 0;
        int j = 0;
        Map<String,String> map = new HashMap<>();

        while (i < strings.length && j < patterns.length ) {

            String string = strings[i];
            String pattern = patterns[j];

            if(map.containsKey(string)) {
                if (!map.get(string).equals(pattern)) {
                    return false;
                }
            }
            else if (map.containsValue(pattern)) {
                return false;
            }
            else {
                map.put(string,pattern);
            }
            i++;
            j++;
        }
        return true;
    }

}
