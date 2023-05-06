package Algorithm.DP;

public class LC_152 {

    // LC_152.乘积最大的子数组
    public int maxProduct(int[] nums) {
        // 与和最大的子数组dp的不同之处在于 第i处的最优解未必是i-1处的最优解转移得到的
        int n = nums.length;
        int ans = 0;
        // dp[i][0]表示第i个元素结尾的乘积最大子数组的乘积
        // dp[i][1]表示第i个元素结尾的乘积最小子数组的乘积
        var dp = new int[n][2];
        dp[0][0] = dp[0][1] = ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 重点 dp[i - 1][1] * nums[i]
            // dp[i - 1][1]如果是一个很小负数并且当前nums[i]也是负数,乘积会变大
            dp[i][0] = Math.max(Math.max(dp[i - 1][0] * nums[i], nums[i]), dp[i - 1][1] * nums[i]);
            // 维护小子数组乘积
            dp[i][1] = Math.min(Math.min(dp[i - 1][1] * nums[i], nums[i]), dp[i - 1][0] * nums[i]);
            ans = Math.max(ans, dp[i][0]);
        }
        // for (var d : dp) System.out.println(Arrays.toString(d));
        return ans;
    }

    public static void main(String[] args) {

    }
}
