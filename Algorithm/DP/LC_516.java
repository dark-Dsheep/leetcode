package Algorithm.DP;

public class LC_516 {

    // 子问题 LC1312. 让字符串成为回文串的最少插入次数
    public int longestPalindromeSubseq(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        return LCS(s, rev);
    }
    // 求 s 与 rev的最长公共子序列
    int LCS(String s, String rev) {
        int n = s.length();
        s = " " + s;
        rev = " " + rev;
        char[] sc = s.toCharArray();
        char[] rc = rev.toCharArray();
        int[][] dp = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= n; j ++) {
                if (sc[i] == rc[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][n];
    }

    int[][] dp = new int[1005][1005];

    // 第II类区间DP
    public int longestPalindromeSubseq2(String s) {
        // 状态定义: dp[i][j] => 字符串S[i:j]里是回文串的最长子序列的长度
        int n = s.length();
        s = " " + s;
        for (int len = 1; len <= n; len++) {            // 区间大小
            for (int i = 1; i + len - 1 <= n; i++) {    // 起始位置
                int j = i + len - 1;
                // 大区间 向小区间转移
                if (len == 1) {
                    dp[i][j] = 1;
                } else if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {

    }
}
