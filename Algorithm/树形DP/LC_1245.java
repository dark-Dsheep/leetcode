package Algorithm.树形DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_1245 {

    /**
     * 1245. 树的直径
     */
    int ans;
    List<Integer>[] g;
    public int treeDiameter(int[][] edges) {
        int n = edges.length;
        g = new ArrayList[n+1];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (var e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        dfs(0, -1);
        return ans;
    }

    int dfs(int x, int fa) {
        int v1 = 0;
        for (int y : g[x]) {
            if (y != fa) {
                int v2 = dfs(y, x) + 1;
                ans = Math.max(ans, v1 + v2);
                v1 = Math.max(v1, v2);
            }
        }
        return v1;
    }


    public static void main(String[] args) {

    }
}
