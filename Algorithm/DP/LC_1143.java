package Algorithm.DP;

public class LC_1143 {


//    1143. 最长公共子序列
    public int longestCommonSubsequence(String t1, String t2) {
        // LCS系列
        int m = t1.length(), n = t2.length();
        t1 = " " + t1;
        t2 = " " + t2;
        var dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (t1.charAt(i) == t2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j  - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {

    }
}
