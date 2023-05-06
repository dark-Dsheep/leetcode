package DataStructure.单调栈;

import java.util.LinkedList;

public class LC_907 {

    static final int MOD = (int) 1e9 + 7;

    /*
        907. 子数组的最小值之和
     */
    public int sumSubarrayMins(int[] arr) {
        // 单调栈 + 贡献法
        // 每个元素作为子数组最小元素的次数
        var n = arr.length;
        var left = new int[n];  // 记录左边第一个小于当前数字的下标
        var right = new int[n]; // 记录右边第一个小于等于当前数字的下标 避免区间重复统计子数组
        var stack = new LinkedList<Integer>();
        stack.push(-1);
        for (var i = 0; i < n; i++) {
            while (stack.size() > 1 && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            left[i] = stack.peek();
            stack.push(i);
        }
        stack.clear();
        stack.push(n);
        for (var i = n - 1; i >= 0; i--) {
            while (stack.size() > 1 && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            right[i] = stack.peek();
            stack.push(i);
        }
        var res = 0L;
        // 计算贡献度
        for (var i = 0; i < n; i++) {
            res += (long) arr[i] * (i - left[i]) * (right[i] - i);
        }
        return (int) (res % MOD);
    }

    public static void main(String[] args) {
         var arr = new int[] {3, 1, 2, 4};
        System.out.println(new LC_907().sumSubarrayMins(arr));
    }
}
