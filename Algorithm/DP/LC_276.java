package Algorithm.DP;

public class LC_276 {

    /*
        276. 栅栏涂色
     */
    public int numWays(int n, int k) {
        if (n == 1) return k;       // 一个栅栏 有k种涂法
        if (n == 2) return k * k;   // 两个栅栏 有k * k种涂法
        int[] dp = new int[n];      // dp[i] -> 第i个栅栏的涂法
        dp[0] = k;
        dp[1] = k * k;
        /*
            当出现3个或者3个以上的栅栏，那么当前涂色有2种情况推导而来
            1. 上一个栅栏连续涂2个相同颜色 dp[i] = dp[i - 2] * (k - 1)
            2. 上一个栅栏涂1个颜色        dp[i] = dp[i - 1] * (k - 1)
         */
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 2] * (k - 1) + dp[i - 1] * (k - 1);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {

    }
}
