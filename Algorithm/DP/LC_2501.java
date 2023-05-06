package Algorithm.DP;

import java.util.Arrays;
import java.util.HashMap;

public class LC_2501 {
//    2501. 数组中最长的方波
    long[] a = new long[100010];
    int[] dp = new int[100010];   // dp[i]表示以i结尾数组的最长方波
    HashMap<Long, Integer> map = new HashMap<>();

    public int longestSquareStreak(int[] nums) {
        Arrays.fill(dp, 1);
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            a[i] = nums[i];
            map.put(a[i], i);
        }
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            long x = a[i] * a[i];
            if (map.containsKey(x)) dp[i] = dp[map.get(x)] + 1;
            ans = Math.max(ans, dp[i]);
        }
        return ans == 1 ? -1 : ans;
    }

    public static void main(String[] args) {

    }
}
