package Algorithm.DP;

public class LC_1039 {

    Integer[][] f = new Integer[60][60];
    int[] a;
    // 一模一样的题目 LC.312 戳气球
    // 一模一样的题目 LC.1547 切棍子的最小成本

    public int minScoreTriangulation(int[] values) {
        a = values;
        return dfs(0, a.length-1);
    }

    int dfs(int i, int j) {
        if (i + 1 >= j) return 0;
        if (f[i][j] != null) return f[i][j];
        int ans = 0x3f3f3f;
        // 枚举顶点k
        for (int k = i+1; k < j; k++) {
            int v = a[i] * a[k] * a[j];
            ans = Math.min(ans, v + dfs(i, k) + dfs(k, j));
        }
        return f[i][j] = ans;
    }

    public static void main(String[] args) {

    }
}
