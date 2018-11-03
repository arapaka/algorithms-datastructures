package LeetCode.heaps;

import java.util.*;

/**
 * Created by archithrapaka on 5/8/17.
 */
public class TopKFrequentElements {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        PriorityQueue<Num> pq = new PriorityQueue<>(Comparator.comparing(Num::getFreq));
        Map<Integer, Integer> mapFreq = new HashMap<>();
        for (int num : nums) {
            if (mapFreq.containsKey(num)) {
                mapFreq.put(num, mapFreq.get(num) + 1);
            } else {
                mapFreq.put(num, 1);
            }
        }

        for (int val : mapFreq.keySet()) {
            int freq = mapFreq.get(val);
            Num num = new Num(val, freq);

            if (pq.size() == k) {
                if (freq > pq.peek().freq) {
                    pq.poll();
                    pq.add(num);
                }
            } else {
                pq.add(num);
            }
        }
        List<Integer> topK = new ArrayList<>();
        while (pq.size() > 0) {
            topK.add(pq.poll().val);
        }
        Collections.sort(topK);
        return topK;
    }

    static class Num {
        int val;
        int freq;

        public Num(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }

        public int getFreq() {
            return freq;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(topKFrequent(a, k));
    }
}
