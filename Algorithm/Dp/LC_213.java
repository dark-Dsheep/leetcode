package Algorithm.Dp;

import java.util.Arrays;

public class LC_213 {


    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        // 把环拆分成两个队列 分别计算最大值
        var a = getMax(Arrays.copyOfRange(nums, 0, nums.length - 1));
        var b = getMax(Arrays.copyOfRange(nums, 1, nums.length));
        return Math.max(a, b);
    }

    private int getMax(int[] nums) {
        if (nums.length < 2) return nums[0];
        var n = nums.length;
        var dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (var i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {

        System.out.println(new LC_213().rob(new int[]{3}));
    }
}
