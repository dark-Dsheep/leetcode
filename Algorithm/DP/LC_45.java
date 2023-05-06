package Algorithm.DP;

import java.util.Arrays;

public class LC_45 {


    /*
        跳跃游戏II
     */
    public int jump(int[] nums) {
        var n = nums.length;
        // 状态定义: dp[i]表示跳到i处的最小跳跃次数
        var dp = new int[n];
        Arrays.fill(dp, 0x3f3f3f);
        dp[0] = 0;
        for (var i = 1; i < n; i++) {
            for (var j = 0; j < i; j++) {
                // 跳到i的这个位置有两种情况
                // 1.从j 一步跳过 i (前提是 j + nums[j] >= i)
                // 2.从 i-1 跳一步到 i

                // if (j + nums[j] >= i) {
                //     dp[i] = Math.min(dp[i], Math.min(dp[i - 1] + 1, dp[j] + 1));
                // } else {
                //     dp[i] = Math.min(dp[i - 1] + 1, dp[i]);
                // }

                // 贪心优化
                if (dp[j] < 0x3f3f3f && j + nums[j] >= i) {
                    dp[i] = dp[j] + 1;
                    break;
                }

            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n - 1];
    }

    public static void main(String[] args) {
        var nums = new int[]{3, 2, 1};
        System.out.println(new LC_45().jump(nums));
    }
}
