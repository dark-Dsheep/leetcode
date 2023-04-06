package Algorithm.Dp;

import java.util.Arrays;

public class LC_673 {

    /*
        673. 最长递增子序列的个数
     */

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        var dp = new int[n];
        var cnt = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // 出现另一种以i结尾最大的子序列
                    if (dp[j] + 1 == dp[i]) cnt[i] += cnt[j];
                    // 找到新的最长递增子序列
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == max) ans += cnt[i];
        }
        return ans;
    }



    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(new LC_673().findNumberOfLIS(nums));
    }
}
