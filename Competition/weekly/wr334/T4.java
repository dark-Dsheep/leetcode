package Competition.weekly.wr334;

import java.util.PriorityQueue;

public class T4 {

    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    boolean[][] vis = new boolean[1010][1010];
    public int minimumTime(int[][] g) {
        // 特判 起点
        if (g[0][1] > 1 && g[1][0] > 1) return -1;
        int m = g.length;
        int n = g[0].length;
        var pq = new PriorityQueue<int[]>((o1, o2) -> o1[2] - o2[2]);
        vis[0][0] = true;
        pq.offer(new int[]{0, 0, 0});
        while (pq.size() > 0) {
            var p = pq.poll();
            int x = p[0], y = p[1], time = p[2];
            if (x == m - 1 && y == n - 1) return time;
            for (var d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || vis[nx][ny]) continue;
                // 当前的时间还不能到达g[nx][ny], 判断是否需要来回跳
                if (g[nx][ny] > time + 1) {
                    int k = g[nx][ny] - time; // 时间差
                    System.out.println("下一个点: " + nx + ", " + ny);
                    System.out.println("当前时间 time: " + time);
                    System.out.println("当前时间差 k: " + k);
                    // 时间相差为奇数 到g[nx][ny]的时间是 time + k
                    // 时间相差为偶数 到g[nx][ny]的时间是 time + k + 1
                    if ((k & 1) == 0) {
                        pq.offer(new int[]{nx, ny, time + k + 1});
                    } else {
                        pq.offer(new int[]{nx, ny, time + k});
                    }
                } else {
                    pq.offer(new int[]{nx, ny, time + 1});
                }
                vis[nx][ny] = true;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] g = {
                {0, 1, 3, 2},
                {5, 1, 2, 5},
                {4, 3, 8, 6}
        };
        System.out.println(new T4().minimumTime(g));
    }
}
