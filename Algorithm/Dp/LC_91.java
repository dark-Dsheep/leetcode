package Algorithm.Dp;


import java.util.Arrays;

public class LC_91 {

    /*
        91. 解码方法
     */
    public int numDecodings(String s) {
        var n = s.length();
        s = " " + s;
        // 状态定义: dp[i] 表示以i结尾的字符串解码方法数
        var dp = new int[n + 1];
        dp[0] = 1;
        for (var i = 1; i <= n; i++) {
            // 分类讨论 i
            // 1.s[i]单独作为一个方案 1 <= s[i] <= 9
            // 2.s[i]与s[i-1] 作为一个方案 10 <= s[i-1, i] <= 26
            // 3.s[i]既能单独作为一个方案 也能与s[i-1]组成一个方案
            int a = s.charAt(i) - '0';                  // 单独作为一个方案
            int b = (s.charAt(i - 1) - '0') * 10 + a;   // 与前一个数字组成一个方案
            if (1 <= a && a <= 9) dp[i] = dp[i - 1];
            if (10 <= b && b <= 26) dp[i] += dp[i - 2];
        }
        return dp[n];
    }

    private int[] memo = new int[110];

    public int numDecodings1(String s) {
        Arrays.fill(memo, -1);
        return dfs(s, 0);
    }

    // 记忆化搜索
    private int dfs(String ss, int idx) {
        if (idx >= ss.length()) return 1;
        if (ss.charAt(idx) == '0') return 0;
        if (memo[idx] != -1) return memo[idx];
        var a = dfs(ss, idx + 1);
        var b = 0;
        if (idx + 2 <= ss.length() && Integer.parseInt(ss.substring(idx, idx + 2)) <= 26) {
            b = dfs(ss, idx + 2);
        }
        memo[idx] = a + b;
        return memo[idx];
    }

    public static void main(String[] args) {
        var s = "27";
        System.out.println(new LC_91().numDecodings1(s));
    }
}
