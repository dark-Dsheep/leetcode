package Competition.weekly.wr341;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T4 {

    List<Integer>[] g;
    int[] price;

    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        this.price = price;
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g[u].add(v);
            g[v].add(u);
        }
        int ans = 0;
        for (int[] t : trips) {
            int st = t[0];
            int ed = t[1];
            ans += solve(st, ed, n);
        }
        return ans;
    }

    int solve(int st, int ed, int n) {
        int x = 0;
        int val = 0x3f3f3f;
        for (int i = 0; i < n; i++) {
            if (!g[i].contains(st) && !g[i].contains(ed)) {
                if (val > price[i]) {
                    x = i;
                }
            }
        }
        var q = new LinkedList<int[]>();
        q.offer(new int[]{st, -1, price[st] / 2});
        while (q.size() > 0) {
            var p = q.poll();
            int u = p[0], fa = p[1], tot = p[2];
            if (u == ed) return tot;
            for (int v : g[u]) {
                if (v != fa) {
                    if (!g[x].contains(v)) {
                        q.offer(new int[]{v, u, tot + price[v] / 2});
                    } else {
                        q.offer(new int[]{v, u, tot + price[v]});
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] e = {{0, 1}, {1, 2}, {1, 3}};
        int[] p = {2, 2, 10, 6};
        int[][] t = {{0, 3}, {2, 1}, {2, 3}};
        System.out.println(new T4().minimumTotalPrice(n, e, p, t));
    }
}
