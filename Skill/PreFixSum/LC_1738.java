package Skill.PreFixSum;

import java.util.PriorityQueue;

public class LC_1738 {

//    1738. 找出第 K 大的异或坐标值

    public int kthLargestValue(int[][] matrix, int k) {
        // 二维前缀和
        int m = matrix.length;
        int n = matrix[0].length;
        var g = new int[m + 1][n + 1];
        var pq = new PriorityQueue<Integer>((a, b) -> a - b);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 下标从1开始计算
                int x = i + 1;
                int y = j + 1;
                g[x][y] = matrix[i][j];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                g[i][j] = g[i - 1][j] ^ g[i][j - 1] ^ g[i - 1][j - 1] ^ g[i][j];
                pq.offer(g[i][j]);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }

        return pq.poll();
    }

    public static void main(String[] args) {

    }
}
