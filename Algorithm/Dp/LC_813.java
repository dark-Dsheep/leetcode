package Algorithm.Dp;

public class LC_813 {

//    813. 最大平均值和的分组

    int[] g;
    // 第I类区间DP
    public double largestSumOfAverages(int[] nums, int k) {
        int N = nums.length, K = k;
        g = new int[N + 1];
        for (int i = 1; i <= N; i++) g[i] = nums[i - 1];
        // dp[i][k]表示在g[0:i]划分k个子数组的最优解
        var dp = new double[N + 1][K + 1];
        // 初始化k=1的时候 dp[i][k]的值
        for (int i = 1; i <= N; i++) dp[i][1] = getAvg(g, 1, i);
        dp[0][0] = 0;
        for (int i = 1; i <= N; i++) {
            for (k = 2; k <= Math.min(i, K); k++) {
                // dp[i][k] = -0x3f3f3f;
                for (int j = i; j >= k; j--) {
                    double avg = getAvg(g, j, i);
                    dp[i][k] = Math.max(dp[i][k], dp[j - 1][k - 1] + avg);
                }
            }
        }
        return dp[N][K];
    }
    // 计算子数组平均值
    double getAvg(int[] nums, int j, int i) {
        double sum = 0;
        for (int l = j; l <= i; l++) sum += nums[l];
        return sum / (i - j + 1);
    }


    public static void main(String[] args) {
        int[] nums = {9, 1, 2, 3, 9};
        int k = 3;
        System.out.println(new LC_813().largestSumOfAverages(nums, k));
    }
}
