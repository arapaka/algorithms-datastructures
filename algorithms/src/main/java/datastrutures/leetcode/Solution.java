package datastrutures.leetcode;

import java.util.*;

/**
 * Created by archith.rapaka on 5/8/17.
 */
public class Solution {
    public static int thirdMax(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

// 		for (int num:nums) {
// 			set.add(num);
// 		}

        int i;
        for (i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }

        while (i < nums.length) {
            int item = nums[i];

            if (pq.size() == k) {

                if (item > pq.peek()) {
                    pq.poll();
                    pq.offer(item);
                }
            } else {
                pq.offer(item);
            }
            i++;
        }

        List<Integer> answers = new ArrayList<>(pq);
        Collections.sort(answers);
        int y = k;
        int d = answers.size();
        while (y > 0) {
            d--;
            y--;
        }
        return answers.get(d);
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(thirdMax(nums, 2));
    }
}
