package Algorithm.Dp;

public class LC_509 {

    /*
        509. 斐波那契数
     */
    public int fib(int n) {
        int[] dp = new int[40];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {

    }
}
