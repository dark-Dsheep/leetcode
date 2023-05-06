package 技巧.前缀和;

public class LC_1139 {


//    1139. 最大的以 1 为边界的正方形

    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        var rowSum = new int[m][n + 1];
        var colSum = new int[n][m + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i][j + 1] = rowSum[i][j] + grid[i][j];
                colSum[j][i + 1] = colSum[j][i] + grid[i][j];
            }
        }
        int d = Math.min(m, n);
        for ( ; d > 0; d--) {                       // 枚举边长
            for (int i = 0; i <= m - d; i++) {      // 枚举左上角下标
                for (int j = 0; j <= n - d; j++) {
                    if (rowSum[i][j + d] - rowSum[i][j] == d &&
                            colSum[j][i + d] - colSum[j][i] == d &&
                            rowSum[i + d - 1][j + d] - rowSum[i + d - 1][j] == d &&
                            colSum[j + d - 1][i + d] - colSum[j + d - 1][i] == d)
                        return d * d;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
