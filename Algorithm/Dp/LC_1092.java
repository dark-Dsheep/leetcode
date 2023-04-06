package Algorithm.Dp;

public class LC_1092 {


//    1092. 最短公共超序列

    public String shortestCommonSupersequence(String s1, String s2) {
        // 求LCS
        int m = s1.length(), n = s2.length();
        s1 = " " + s1;
        s2 = " " + s2;
        var dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // 构造答案
        var ans = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (s1.charAt(i) == s2.charAt(j))  { ans.append(s1.charAt(i)); i--; j--; }
            else if (dp[i][j] == dp[i - 1][j]) { ans.append(s1.charAt(i)); i--; }
            else if (dp[i][j] == dp[i][j - 1]) { ans.append(s2.charAt(j)); j--; }
        }
        while (i > 0) ans.append(s1.charAt(i--));
        while (j > 0) ans.append(s2.charAt(j--));
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        var s1 = "abac";
        var s2 = "cab";
        System.out.println(new LC_1092().shortestCommonSupersequence(s1, s2));
    }
}
