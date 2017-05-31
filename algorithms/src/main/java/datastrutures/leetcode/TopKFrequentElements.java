package datastrutures.leetcode;

import java.util.*;

/**
 * Created by archith.rapaka on 5/8/17.
 */
public class TopKFrequentElements {

	public static List<Integer> topKFrequent(int[] nums, int k) {

		Map<Integer,Integer> mapFreq = new HashMap<>();

		for (int num:nums) {
			 if(mapFreq.containsKey(num)) {
				 mapFreq.put(num,mapFreq.get(num)+1);
			 }
			 else  {
				 mapFreq.put(num,1);
			 }

		}

		PriorityQueue<Num> pq = new PriorityQueue<>(Comparator.comparing(Num::getFreq));
		for (int key:mapFreq.keySet()) {
			Num num = new Num(key,mapFreq.get(key));
			 if(pq.size() == k) {
				 if(num.freq > pq.peek().freq) {
					 pq.poll();
					 pq.add(num);
				 }

			 }
			pq.offer(num);
		}

		List<Integer> topK = new ArrayList<>();
		while (pq.size() > 0) {
			topK.add(pq.poll().value);
		}
		return topK;
	}

	static class Num  {
		int value;
		int freq;

		public Num(int value , int freq) {
			this.value = value;
			this.freq = freq;
		}

		public int getFreq(){
			return freq;
		}
	}

	public static void main(String[] args) {
		int[] nums = {4,1,-1,2,-1,2,3}; int k = 2;
       System.out.println(topKFrequent(nums,k));

	}
}
