package Algorithm.DP;

public class LC_926 {

    /*
        926. 将字符串翻转到单调递增
     */

    public int minFlipsMonoIncr(String s) {
        // 状态定义: dp[i][j] 表示长度为i的字符串以j('1' 或 '0')结尾的最小翻转次数
        // 考虑最后一个字符的情况
        // 最后一个字符是 '0' 前面只能是全部翻转成0的样子       00000000
        // 最后一个字符是 '1' 前面可以是反转成0,可以是反转成1   00001111 or 11111111

        // dp[i][0] = dp[i - 1][0] + (s[i] == '0' ? 0 : 1)
        // dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + (s[i] == '1' ? 0 : 1);
        int n = s.length();
        var dp = new int[n + 1][2];
        dp[0][0] = s.charAt(0) == '0' ? 0 : 1;
        dp[0][1] = s.charAt(1) == '1' ? 0 : 1;
        for (int i = 1; i < n; i++) {
            var cur = s.charAt(i);
            dp[i][0] = dp[i - 1][0] + (cur == '0' ? 0 : 1);
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + (cur == '1' ? 0 : 1);
        }
        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }

}
