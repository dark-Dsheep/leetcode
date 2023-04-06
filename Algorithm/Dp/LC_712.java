package Algorithm.Dp;

public class LC_712 {

//    712. 两个字符串的最小ASCII删除和

    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        s1 = " " + s1;
        s2 = " " + s2;
        var dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) dp[i][0] = dp[i - 1][0] + s1.charAt(i);
        for (int j = 1; j <= n; j++) dp[0][j] = dp[0][j - 1] + s2.charAt(j);
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int cost1 = s1.charAt(i), cost2 = s2.charAt(j);
                    // s1,s2中选一个删除代价小的
                    dp[i][j] = Math.min(dp[i - 1][j] + cost1, dp[i][j - 1] + cost2);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {

    }
}
