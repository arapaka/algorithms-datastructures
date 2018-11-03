package Facebook;

import java.util.*;

/**
 * Created by archithrapaka on 4/22/17.
 * // You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * <p>
 * // Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * <p>
 * // You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 */
public class FirstBadVersion {

    public static int findVersion(int[] a) {
        int start = 0;
        int end = a.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            int scope = (end - start) + start;

            if (!isBadVersion(mid, scope)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    static boolean isBadVersion(int number, int bound) {
        Random rand = new Random();
        return number == rand.nextInt(999);
    }

    public static void main(String[] args) {
        int[] a = new int[1000];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        System.out.println(findVersion(a));
        final List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("krish");
        List<String> unmodifiable = Collections.unmodifiableList(list);
        //unmodifiable.add("hello");
        //Collection<SortedSet> S = new C
        Map<String, String> map = new HashMap<>();
        map.put("znet", "123");
        map.put("manga", "manga");
        TreeMap<String, String> tm = new TreeMap<>(map);
        for (Map.Entry entry : tm.entrySet()) {
            System.out.println(entry.getKey() + "," + entry.getValue());
        }
    }
}
