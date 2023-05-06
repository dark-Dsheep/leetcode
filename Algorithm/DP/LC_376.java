package Algorithm.DP;

public class LC_376 {

    /*
        376. 摆动序列
     */

    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        // j: 0-差值正数 1-差值负数
        // 状态定义: dp[i][j] 表示以i结尾,结尾状态为j的最长摆动序列
        var dp = new int[n + 1][2];
        dp[0][0] = dp[0][1] = 1;
        int res = 1;
        for (int i = 1; i < n; i++) {
            dp[0][0] = dp[0][1] = 1;
            if (nums[i] - nums[i - 1] > 0) {
                // 状态为0,由上一个状态为1的递推过来
                dp[i][0] = dp[i - 1][1] + 1;
                dp[i][1] = dp[i - 1][1];    // 重点: 子序列不一定是连续的
            } else if (nums[i] - nums[i - 1] < 0) {
                // 状态为1,由上一个状态为0的递推过来
                dp[i][1] = dp[i - 1][0] + 1;
                dp[i][0] = dp[i - 1][0];
            } else {
                // 保持上一个状态
                dp[i][1] = dp[i - 1][1];
                dp[i][0] = dp[i - 1][0];
            }
            res = Math.max(res, Math.max(dp[i][0], dp[i][1]));
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {1,17,5,10,13,15,10,5,16,8};
        System.out.println(new LC_376().wiggleMaxLength(nums));
    }
}
