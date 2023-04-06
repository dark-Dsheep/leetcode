package Skill.PreFixSum;

public class LC_1292 {


//    1292. 元素和小于等于阈值的正方形的最大边长

    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        var s = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = i + 1, y = j + 1;
                s[x][y] = mat[i][j];
            }
        }
        // 构建二维前缀和
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                s[i][j] += s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1];
            }
        }
        int ans = 0;
        for (int i = 1; i <= m; i++) {                   // 上界
            for (int j = 1; j <= n; j++) {               // 下界
                for (int k = 1; k <= i && k <= j; k++) { // 枚举边长k
                    int val = s[i][j] - s[i - k][j] - s[i][j - k] + s[i - k][j - k];
                    if (val > threshold) break;
                    ans = Math.max(ans, k);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
