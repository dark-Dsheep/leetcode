package Algorithm.Bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_1992 {

    int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m, n = 0;

    /*
        1992. 找到所有的农场组
     */
    public int[][] findFarmland(int[][] land) {
        m = land.length;
        n = land[0].length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    // 找到农场坐标对
                    int[] farm = bfs(land, i, j);
                    list.add(farm);
                }
            }
        }
        int[][] res = new int[list.size()][4];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private int[] bfs(int[][] land, int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        int maxi = r, maxj = c;
        land[r][c] = 0;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int x = p[0], y = p[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + d[i][0];
                int ny = y + d[i][1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || land[nx][ny] == 0) {
                    continue;
                }
                land[nx][ny] = 0;
                maxi = Math.max(maxi, nx);
                maxj = Math.max(maxj, ny);
                queue.offer(new int[]{nx, ny});
            }
        }
        return new int[]{r, c, maxi, maxj};
    }


    public static void main(String[] args) {

    }
}
