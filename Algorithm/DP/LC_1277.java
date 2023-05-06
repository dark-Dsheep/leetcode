package Algorithm.DP;

public class LC_1277 {


    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        var dp = new int[m][n];
        dp[0][0] = matrix[0][0];
        int res = matrix[0][0];
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 1) {
                dp[i][0] = 1;
                res++;
            }
        }
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 1) {
                dp[0][j] = 1;
                res++;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
                res += dp[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        };
        System.out.println(new LC_1277().countSquares(matrix));
    }
}
