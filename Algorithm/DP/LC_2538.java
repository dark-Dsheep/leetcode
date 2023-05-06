package Algorithm.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_2538 {

    List<Integer>[] g;
    long ans;

    public long maxOutput(int n, int[][] edges, int[] price) {
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (var e : edges) {
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x);
        }
        dfs(0, -1, price);
        return ans;
    }

    long[] dfs(int x, int fa, int[] price) {
        long p = price[x], maxS1 = p, maxS2 = 0;
        for (int y : g[x]) {
            if (y != fa) {
                var ret = dfs(y, x, price);
                long s1 = ret[0], s2 = ret[1];
                ans = Math.max(ans, Math.max(maxS1 + s2, maxS2 + s1));
                maxS1 = Math.max(maxS1, s1 + p);
                maxS2 = Math.max(maxS2, s2 + p);
            }
        }
        return new long[]{maxS1, maxS2};
    }



    public static void main(String[] args) {

    }

}
