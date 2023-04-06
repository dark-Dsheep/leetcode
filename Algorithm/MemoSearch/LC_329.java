package Algorithm.MemoSearch;

public class LC_329 {

    /*
        329. 矩阵中的最长递增路径

     */
    private int[][] memo = new int[210][210];
    private int m, n = 0;

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        var res = 0;
        for (var i = 0; i < m; i++) {
            for (var j = 0; j < n; j++) {
                var len = dfs(i, j, Integer.MIN_VALUE, matrix);
//                System.out.println("x=" + i + " y=" + j + "  len => " + len);
                res = Math.max(res, len);
            }
        }
        return res;
    }

    private int dfs(int x, int y, int preVal, int[][] matrix) {
        int res = 0;
        if (x < 0 || x >= m || y < 0 || y >= n) return 0;
        if (matrix[x][y] <= preVal) return 0;
        if (memo[x][y] != 0) return memo[x][y];
        res++;                                  // 初始最长递增路径都为1
        res += Math.max(
                Math.max(dfs(x - 1, y, matrix[x][y], matrix), dfs(x + 1, y, matrix[x][y], matrix)),
                Math.max(dfs(x, y - 1, matrix[x][y], matrix), dfs(x, y + 1, matrix[x][y], matrix))
        );
        memo[x][y] = res; // 记忆化
        return res;
    }

    public static void main(String[] args) {
        var matrix = new int[][] {
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}
        };
        System.out.println(new LC_329().longestIncreasingPath(matrix));
    }
}
