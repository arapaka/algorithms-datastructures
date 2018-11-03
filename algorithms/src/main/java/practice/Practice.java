package practice;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Practice {
    public Map<String, Integer> word0(String[] strings) {
        Integer key = 0;

        return Arrays.stream(strings)
                .collect(Collectors.toMap(s -> s, s -> 0));

    }

}
