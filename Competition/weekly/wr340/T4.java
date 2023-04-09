package Competition.weekly.wr340;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class T4 {


    public int minimumVisitedCells(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        TreeSet<Integer>[] rows = new TreeSet[n];
        TreeSet<Integer>[] cols = new TreeSet[m];
        for (int i = 0; i < n; i++) {
            rows[i] = new TreeSet<>();
            for (int j = 0; j < m; j++) {
                rows[i].add(j);
            }
        }
        for (int i = 0; i < m; i++) {
            cols[i] = new TreeSet<>();
            for (int j = 0; j < n; j++) {
                cols[i].add(j);
            }
        }
        var dist = new int[n][m];
        for (var row : dist) {
            Arrays.fill(row, 0x3f3f3f);
        }
        var q = new LinkedList<int[]>();
        q.offer(new int[]{0, 0});
        rows[0].remove(0);
        cols[0].remove(0);
        while (q.size() > 0) {
            var p = q.poll();
            int x = p[0], y = p[1];
            int r = grid[x][y] + y;
            int b = grid[x][y] + x;
            while (true) {
                var next = rows[x].higher(y);
                if (next == null || next > r) break;
                dist[x][next] = dist[x][y] + 1;
                rows[x].remove(next);
                cols[next].remove(x);
                q.offer(new int[]{x, next});
            }
            while (true) {
                var next = cols[y].higher(x);
                if (next == null || next > b) break;
                dist[next][y] = dist[x][y] + 1;
                rows[next].remove(y);
                cols[y].remove(next);
                q.offer(new int[]{next, y});
             }
        }
        int ans = dist[n-1][m-1];
        return ans == 0x3f3f3f ? -1 : ans;
    }


    public static void main(String[] args) {
        int[][] g = {{3, 4, 2, 1}, {4, 2, 3, 1}, {2, 1, 0, 0}, {2, 4, 0, 0}};
        System.out.println(new T4().minimumVisitedCells(g));
    }
}
