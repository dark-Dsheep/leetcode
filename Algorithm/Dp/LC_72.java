package Algorithm.Dp;

public class LC_72 {


//    72. 编辑距离

    public int minDistance(String w1, String w2) {
        int m = w1.length(), n = w2.length();
        w1 = " " + w1;
        w2 = " " + w2;
        var dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) dp[i][0] = i;
        for (int j = 1; j <= n; j++) dp[0][j] = j;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (w1.charAt(i) == w2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insert = dp[i - 1][j] + 1;
                    int delete = dp[i - 1][j - 1] + 1;
                    int replace = dp[i][j - 1] + 1;
                    dp[i][j] = Math.min(Math.min(insert, delete), replace);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {

    }
}
