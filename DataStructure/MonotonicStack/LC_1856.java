package DataStructure.MonotonicStack;

import java.util.LinkedList;

public class LC_1856 {

    /*
        1856. 子数组最小乘积的最大值
     */
    static final int MOD = (int) 1e9 + 7;

    public int maxSumMinProduct(int[] nums) {
        var n = nums.length;
        var preSum = new long[n + 1];
        preSum[0] = 0;
        // 计算前缀和数组
        for (var i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        var left = new int[n];  // 记录左边第一个小于当前数字的下标
        var right = new int[n]; // 记录右边第一个小于等于当前数字的下标 避免区间重复统计子数组
        var stack = new LinkedList<Integer>();
        stack.push(-1);
        for (var i = 0; i < n; i++) {
            while (stack.size() > 1 && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            left[i] = stack.peek();
            stack.push(i);
        }
        stack.clear();
        stack.push(n);
        for (var i = n - 1; i >= 0; i--) {
            while (stack.size() > 1 && nums[stack.peek()] > nums[i]) {
                stack.pop();
            }
            right[i] = stack.peek();
            stack.push(i);
        }
        var res = 0L;
        // 计算贡献度
        for (var i = 0; i < n; i++) {
            var r = right[i];
            var l = left[i] + 1; // 查询以nums[i]为最小值,区间[l,r]的和
            var subSum = preSum[r] - preSum[l];
            res = Math.max(res, nums[i] * subSum);
        }
        return (int) (res % MOD);
    }

    private int getSubSum(int[] preSum, int right, int left) {
        return preSum[right] - preSum[left];
    }

    public static void main(String[] args) {
        var nums = new int[]{3,1,5,6,4,2};
        System.out.println(new LC_1856().maxSumMinProduct(nums));
    }
}
