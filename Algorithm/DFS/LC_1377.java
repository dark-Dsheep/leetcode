package Algorithm.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_1377 {


    ///1377. T 秒后青蛙的位置

    List<Integer>[] g;
    public double frogPosition(int n, int[][] edges, int t, int target) {
        g = new ArrayList[n+1];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (var e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        g[1].add(0);
        long prod = dfs(1, 0, t, target);
        return prod != 0 ? 1.0 / prod : 0;
    }

    long dfs(int x, int fa, int t, int target) {
        // t秒后必须在target
        if (t == 0) return x == target ? 1 : 0;           // 恰好到达
        if (x == target) return g[x].size() == 1 ? 1 : 0; // 叶子停留在原地
        for (int y : g[x]) {
            if (y != fa) {
                long prod = dfs(y, x, t-1, target); // 找target
                if (prod != 0) {
                    return prod * (g[x].size() - 1);
                }
            }
        }
        return 0; // 未找到target
    }


    public static void main(String[] args) {

    }
}
