package DataStructure.MonotonicStack;

import java.util.LinkedList;

public class LC_84 {


    /*
        LC84-柱状图中的最大的矩形
     */

    private LinkedList<Integer> stack = new LinkedList<>();
    private int[] left = new int[100010];
    private int[] right = new int[100010];
    private int[] h = new int[100010];

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        h[0] = -1;
        h[n + 1] = -1;
        for (int i = 1; i <= n; i++) {
            h[i] = heights[i - 1];
        }
        stack.push(0);
        // 从左至右遍历 -> 查找左边第一个小于当前高度的下标
        for (int i = 1; i <= n; i++) {
            while (h[stack.peek()] >= h[i]) stack.pop();
            left[i] = stack.peek() + 1;
            stack.push(i);
        }
        stack.clear();
        stack.push(n + 1);
        // 从右至左遍历 -> 查找右边第一个小于当前高度的下标
        for (int i = n; i >= 1; i--) {
            while (h[stack.peek()] >= h[i]) stack.pop();
            right[i] = stack.peek() - 1;
            stack.push(i);
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, h[i] * (right[i] - left[i] + 1));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(new LC_84().largestRectangleArea(heights));
    }
}
