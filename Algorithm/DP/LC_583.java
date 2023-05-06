package Algorithm.DP;

public class LC_583 {

//    583. 两个字符串的删除操作
    public int minDistance(String w1, String w2) {
        int m = w1.length(), n = w2.length();
        w1 = " " + w1;
        w2 = " " + w2;
        var dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) dp[i][0] = i;
        for (int j = 1; j <= n; j++) dp[0][j] = j;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (w1.charAt(i) == w2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {

    }
}
