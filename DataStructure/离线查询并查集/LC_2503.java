package DataStructure.离线查询并查集;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LC_2503 {


    int[] fa;
    int[] size;
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length;
        int n = grid[0].length;
        int mn = m * n;

        fa = new int[mn];
        for (int i = 0; i < mn; i++) {
            fa[i] = i;
        }
        size = new int[mn];
        Arrays.fill(size, 1);

        var a = new int[mn][3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i * n + j] = new int[]{grid[i][j], i, j};
            }
        }
        Arrays.sort(a, (p, q) -> p[0] - q[0]);

        int k = queries.length;
        var id = IntStream.range(0, k).boxed().toArray(Integer[]::new);
        Arrays.sort(id, (i, j) -> queries[i] - queries[j]);

        var ans = new int[k];
        int j = 0;
        for (int i : id) {
            int q = queries[i];
            for (; j < mn && a[j][0] < q; j++) {
                int x = a[j][1], y = a[j][2];
                for (var d : dirs) {
                    int nx = x + d[0], ny = y + d[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] >= q) continue;
                    union(x * n + y, nx * n + ny);
                }
            }
            if (grid[0][0] < q) {
                ans[i] = size[find(0)];
            }
        }
        return ans;
    }

    int find(int x) {
        while (x != fa[x]) {
            fa[x] = fa[fa[x]];
            x = fa[x];
        }
        return x;
    }

    void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;
        fa[a] = b;
        size[b] += size[a];
    }

    public static void main(String[] args) {

    }
}
