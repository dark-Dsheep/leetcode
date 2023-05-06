package Algorithm.DP;

public class LC_1312 {

//    1312. 让字符串成为回文串的最少插入次数

    public int minInsertions(String s1) {
        int n = s1.length();
        var s2 = reverse(s1);
        s1 = " " + s1;
        s2 = " " + s2;
        var dp = new int[n + 1][n + 1];
        // s2 和 s1 的LCS
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int lcs = dp[n][n]; // 最长回文子序列的长度
        return n - lcs; // 剩下的全是不构成回文子序列的字符, 插入 n - lcs次再次构成回文子串
    }

    String reverse(String s) {
        var c = s.toCharArray();
        var temp = ' ';
        int i = 0, j = c.length - 1;
        while (i < j) {
            temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(c);
    }


    public static void main(String[] args) {

    }
}
