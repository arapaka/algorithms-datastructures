package LeetCode.TwoPointers;

import java.util.Stack;

/**
 * Created by archithrapaka on 4/16/17.
 */
public class LargestHistogram {

    public int largestRect(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0, max = 0;

        while (i < height.length) {
            if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int p = stack.pop();
                int h = height[p];
                int w = stack.isEmpty() ? i : i - 1 - stack.peek();
                max = Math.max(max, h * w);
            }
        }
        //  for last element
        while (!stack.isEmpty()) {
            int p = stack.pop();
            int h = height[p];
            int w = stack.isEmpty() ? i : i - 1 - stack.peek();
            max = Math.max(max, h * w);
        }
        return max;
    }

    public int maxRectangle2D(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return 0;
        }

        int m = mat.length;
        int n = mat[0].length;
        int[][] height = new int[m][n + 1];
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    height[i][j] = 0;
                } else {
                    height[i][j] = (i == 0) ? 1 : height[i - 1][j] + 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int area = largestRect(height[i]);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {

    }
}
