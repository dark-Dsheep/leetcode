package Algorithm.Dp;

public class LC_44 {

    /*
        44. 通配符匹配
     */
    public boolean isMatch(String ss, String pp) {
        var m = ss.length();
        var n = pp.length();
        ss = " " + ss;
        pp = " " + pp;
        var s = ss.toCharArray();
        var p = pp.toCharArray();
        // 状态定义: dp[i][j]表示以s[i],p[j]结尾是否匹配
        var dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        // 初始化边界
        for (var j = 1; j <= n; j++) {
            if (p[j] == '*') dp[0][j] = true;
            else break;
        }
        for (var i = 1; i <= m; i++) {
            for (var j = 1; j <= n; j++) {
                if (p[j] == '*') {      // p[j] 为 '*'
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {                // p[j] 为普通字符 或者'?'
                    dp[i][j] = dp[i - 1][j - 1] && (s[i] == p[j] || p[j] == '?');
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {

        var s = "aa";
        var p = "a";
        System.out.println(new LC_44().isMatch(s, p));
    }
}
