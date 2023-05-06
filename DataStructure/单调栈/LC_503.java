package DataStructure.单调栈;

import java.util.LinkedList;

public class LC_503 {


    /*
        503. 下一个更大元素 II
     */
    public int[] nextGreaterElements(int[] nums) {
        LinkedList<Integer> stack = new LinkedList<>();
        int n = nums.length;
        int[] res = new int[n];
        for (int i = n * 2 - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i % n]) {
                stack.pop();
            }
            // 取模防止越界
            res[i % n] = stack.isEmpty() ? -1 : nums[stack.peek()];
            stack.push(i % n);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
