package Algorithm.Dp;

import java.util.Arrays;

public class LC_198 {

    /*
      198. 打家劫舍
     */
    public int rob(int[] nums) {
        if (nums.length < 2) return nums[0];
        var n = nums.length;
        // 状态定义: dp[i] 表示第i个房间偷到的最高金额
        var dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (var i = 2; i < n; i++) {
            // 分类讨论第i个房间
            // 1.不偷第i个房间,保持上一个房间偷取的最大值
            // 2.偷取第i个房间,从上上个房间偷取的最大值之和
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }

    private int[] memo = new int[101];

    public int rob2(int[] nums) {
        Arrays.fill(memo, -1);
        return dfs(nums, nums.length - 1);
    }
    // 记忆化搜索
    private int dfs(int[] nums, int i) {
        if (i < 0) return 0;
        if (memo[i] != -1) return memo[i];
        int res = 0;
        res  = Math.max(dfs(nums, i - 1), dfs(nums,i - 2) + nums[i]);
        memo[i] = res; // 记忆化
        return res;
    }

    public static void main(String[] args) {

    }
}
