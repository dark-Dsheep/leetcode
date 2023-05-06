package Algorithm.DP;

public class LC_115 {

    /*
        115. 不同的子序列
     */
    public int numDistinct(String s, String t) {
        var m = s.length();
        var n = t.length();
        s = " " + s;
        t = " " + t;
        var dp = new int[m + 1][n + 1];
        for (var i = 0; i <= m; i++) {  // 初始化第一列
            dp[i][0] = 1;
        }
        dp[0][0] = 1;
        for (int i = 1; i <= m; i++) {          // ...s[i]
            for (int j = 1; j <= n; j++) {      // ...t[j]
                if (j > i) break;
                // 只要 s.charAt(i) == t.charAt(j) 的
                // 那么 dp[i][j] = dp[i-1][j-1] + dp[i-1][j]成立
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        var s = "rabbbit";
        var t = "rabbit";
        System.out.println(new LC_115().numDistinct(s, t));
    }
}
