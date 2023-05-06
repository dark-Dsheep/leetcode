package Algorithm.树形DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_2538 {


    long ans = 0;
    List<Integer>[] g;
    int[] p;

    public long maxOutput(int n, int[][] edges, int[] price) {
        p = price;
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (var e : edges) {
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x);
        }
        dfs(0, -1);
        return 0;
    }

    int dfs(int x, int fa) {

        return -1;
    }

    public static void main(String[] args) {

    }
}
