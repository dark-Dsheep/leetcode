package Skill.Difference;

public class LC_6292 {

    /*
        6292. 子矩阵元素加 1
     */
    // v1: 暴力
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] res = new int[n][n];
        for (int[] q : queries) {
            for (int i = q[0]; i <= q[2]; i++) {
                for (int j = q[1]; j <= q[3]; j++) {
                    res[i][j]++;
                }
            }
        }
        return res;
    }

    // v2: 差分数组
    public int[][] rangeAddQueries2(int n, int[][] queries) {
        int[][] diff = new int[n + 2][n + 2];
        for (int[] q : queries) {
            int x1 = q[0], y1 = q[1], x2 = q[2], y2 = q[3];
            // 为了起始下标为 1，统一需要加 1
            diff[x1 + 1][y1 + 1] += 1;
            diff[x2 + 2][y1 + 1] -= 1;
            diff[x1 + 1][y2 + 2] -= 1;
            diff[x2 + 2][y2 + 2] += 1;
        }
        int[][] res = new int[n][n];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                res[i - 1][j - 1] = (diff[i][j] += diff[i - 1][j] + diff[i][j - 1] - diff[i - 1][j - 1]);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
