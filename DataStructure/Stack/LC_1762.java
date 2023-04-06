package DataStructure.Stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class LC_1762 {

    /*
    1762. 能看到海景的建筑物
     */
    public int[] findBuildings(int[] heights) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(heights.length);
        LinkedList<Integer> stack = new LinkedList<>();
        // 单调递减栈
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) queue.offer(i); // 栈为空的表示后面没有元素比它大
            stack.push(i);
        }
        int[] res = new int[queue.size()];
        int i = 0;
        while (!queue.isEmpty()) {
            res[i++] = queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] heights = {4, 2, 3, 1};
        System.out.println(Arrays.toString(new LC_1762().findBuildings(heights)));
    }
}
