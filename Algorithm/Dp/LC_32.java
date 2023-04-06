package Algorithm.Dp;

import java.math.BigInteger;

public class LC_32 {

    /*
        32. 最长有效括号
     */
    // TODO
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];  // dp[i] 表示以i结尾最长有效括号数量
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            if (s.charAt(i - 1) == ')' && s.charAt(i - 2) == '(') {
                dp[i] = dp[i - 1] + 2;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s = "()()())";
        System.out.println(new LC_32().longestValidParentheses(s));
        BigInteger v = BigInteger.valueOf(1L);
    }
}
