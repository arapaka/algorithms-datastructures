package LeetCode.TwoPointers;

import java.util.Stack;

/**
 * Created by archithrapaka on 4/7/17.
 */
public class EvaluateRPN {

    public static void evaluateRPN(String s) {
        Stack<Integer> stack = new Stack<Integer>();


        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                stack.push(Integer.valueOf("" + s.charAt(i)));
            } else {
                int var1 = stack.pop();
                int var2 = stack.pop();
                char c = s.charAt(i);
                evaluate(var1, var2, c, stack);
            }
        }
        System.out.print(stack.pop());
    }

    public static void evaluate(int var1, int var2, char c, Stack<Integer> stack) {

        int val = 0;
        switch (c) {
            case '*':
                val = var1 * var2;
                break;
            case '+':
                val = var1 + var2;
                break;
            case '/':
                val = var1 / var2;
                break;
            case '-':
                val = var1 - var2;
                break;
        }
        stack.push(val);
    }

    public static void main(String[] args) {
        // System.out.println(  Character.getNumericValue('5'));
        Character.getNumericValue('5');
        String s = "abc";
        evaluateRPN("21+3*");
    }

}
