package Algorithm.DP;

import java.util.Arrays;

public class LC_2547 {

//    2547. 拆分数组的最小代价

    int[] dp = new int[1005];
    int[] g = new int[1005];

    public int minCost(int[] nums, int k) {
        int n = nums.length;
        Arrays.fill(dp, 0x3f3f3f3f);
        System.arraycopy(nums, 0, g, 1, n);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            var map = new int[1005];
            int cost = 0;
            for (int j = i; j >= 1; j--) {
                map[g[j]]++;
                if (map[g[j]] == 2)     cost += 2;
                else if (map[g[j]] > 2) cost += 1;
                dp[i] = Math.min(dp[i], dp[j - 1] + cost + k);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 1};
        int k = 5;
        System.out.println(new LC_2547().minCost(nums, k));
    }
}
