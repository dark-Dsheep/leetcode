package DataStructure.单调栈;

import java.util.LinkedList;

public class LC_739 {


    /*
        739. 每日温度
     */
    public int[] dailyTemperatures(int[] t) {
        LinkedList<Integer> stack = new LinkedList<>();
        int n = t.length;
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            // 要高温，<= 当前温度的pop出队
            while (!stack.isEmpty() && t[stack.peek()] <= t[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
