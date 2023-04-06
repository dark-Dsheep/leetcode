package HardEX;

import java.util.HashSet;
import java.util.LinkedList;

public class LC_1036 {

//    1036. 逃离大迷宫 Rating(2165)

    int N = 1000000;
    int MAX = 100000;
    long base = 131L;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    HashSet<Long> ban = new HashSet<>();

//    BFS + 离散化

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if (blocked.length == 0) return true;
//        当两个点中的任意一点被障碍物围住时，两点将无法连通
        for (var p : blocked) {
            ban.add(p[0] * base + p[1]);
        }
        return check(source, target) && check(target, source);
    }

    boolean check(int[] a, int[] b) {
        var vis = new HashSet<Long>();
        var q = new LinkedList<int[]>();
        q.offer(a);
        vis.add(a[0] * base + a[1]);
        while (q.size() > 0) {
            if (vis.size() > MAX) return true;
            var p = q.poll();
            int x = p[0], y = p[1];
            if (x == b[0] && y == b[1]) return true;
            for (var d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                long k = nx * base + ny;
                if (vis.contains(k) || ban.contains(k)) continue;
                q.offer(new int[]{nx, ny});
                vis.add(k);
            }
        }
        return vis.size() > MAX;
    }

    public static void main(String[] args) {

    }
}
