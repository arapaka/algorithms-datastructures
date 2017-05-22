package LeetCode.TwoPointers;

import datastrutures.stacks.Stack;

/**
 * Created by archithrapaka on 4/11/17.
 */
public class ReverseArrayFun {

    public static void reverseFun(int[] a) {

        int max = a.length/4;
        Stack<Integer> stack = new Stack<>(max); // n/4
        for (int i = 0; i < max; i++) {
             stack.push(a[i]);
        }
    }

    public static void main(String[] args) {

    }
}
