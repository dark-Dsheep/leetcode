package Algorithm.DP;

public class LC_375 {

    int[][] dp = new int[205][205];

//    375. 猜数字大小 II

    public int getMoneyAmount(int n) {
        // len = 1的区间是 [1:1] 猜中代价为0
        for (int len = 2; len <= n; len++) {            // 区间大小
            for (int i = 1; i + len - 1 <= n; i++) {    // 起始位置
                int j = i + len - 1;
                dp[i][j] = 0x3f3f3f;
                for (int k = i; k <= j; k++) {          // 枚举第一猜 k
                    int cur = Math.max(dp[i][k - 1], dp[k + 1][j]) + k;
                    dp[i][j] = Math.min(dp[i][j], cur);
                }
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {

    }

}
