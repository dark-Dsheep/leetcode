package Algorithm.Dp;

import java.util.Arrays;

public class LC_300 {

    /*
        300. 最长递增子序列
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; // dp[i] -> 以i结尾的最长递增子序列
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);

        }
        return res;
    }

    public static void main(String[] args) {
    }
}
