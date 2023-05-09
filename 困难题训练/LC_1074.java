package 困难题训练;

import java.util.HashMap;

public class LC_1074 {

//    1074. 元素和为目标值的子矩阵数量 Rating(2189)

    // 前缀和 + 哈希表 + 枚举

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        var sum = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + matrix[i-1][j-1];
            }
        }
        int ans = 0;
        for (int top = 1; top <= m; top++) {
            for (int bot = top; bot <= n; bot++) {
                int cur = 0;
                var map = new HashMap<Integer, Integer>();
                for (int r = 1; r <= n; r++) { // 枚举每一列
                    cur = sum[bot][r] - sum[top-1][r];
                    if (cur == target) ans++;
                    if (map.containsKey(cur - target)) {
                        ans += map.get(cur - target);
                    }
                    map.merge(cur, 1, Integer::sum);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }


}
