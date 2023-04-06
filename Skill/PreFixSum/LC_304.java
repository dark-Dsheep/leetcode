package Skill.PreFixSum;

public class LC_304 {

    /*
        304. 二维区域和检索 - 矩阵不可变
     */
    // 二维前缀和
    class NumMatrix {
        int[][] g = new int[210][210];
        int n;
        int m;

        public NumMatrix(int[][] matrix) {
            n = matrix.length;
            m = matrix[0].length;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int x = i;
                    int y = j;
                    x++; y++;
                    g[x][y] = matrix[i][j];
                }
            }
            // 构建前缀和
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    g[i][j] += g[i - 1][j] + g[i][j - 1] - g[i - 1][j - 1];
                }
            }
        }
        /**
         preSum[r1][c1]被减了2次
         preSum[r2 + 1][c2 + 1] − preSum[r2 +1][c1] − preSum[r1][c2 + 1] + preSum[r1][c1]
         */

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return g[row2 + 1][col2 + 1] - g[row1][col2 + 1] - g[row2 + 1][col1] + g[row1][col1];
        }
    }

    public static void main(String[] args) {

    }
}
