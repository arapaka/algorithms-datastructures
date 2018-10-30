package tutorialHorizon.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by archith.rapaka on 6/22/17.
 */
public class BinarySearch {

	// non recursive
	public static int binarySearch(int[] a ,int target) {
		int low = 0;
		int high = a.length-1;
		while (low <= high) {
			int mid = (high+low) >>> 1;
			if(a[mid] == target) {
				return mid;
			}
			if(a[mid] > target) {
				high = mid-1;
			}
			else {
				low = mid+1;
			}
		}
		return -1;
	}


	public static void main(String[] args) {
		int[] a = {2,5,8,10,14,44,77,78,99};
		System.out.println(binarySearch(a,77));
		System.out.println(binarySearch(a,44));
		System.out.println(binarySearch(a,99));
		System.out.println(binarySearch(a,5));
		System.out.println(binarySearch(a,89));
		System.out.println(Arrays.binarySearch(a,89));
		List<Integer> list = new ArrayList(Arrays.asList(a));
		int[] copy = new int[list.size()];
		for (int i = 0; i < copy.length; i++) {
			 copy[i] = list.get(i);
		}
	}
}
