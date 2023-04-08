package Algorithm.TopoSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class LC_210 {



//    210. 课程表 II TopSort

    public int[] findOrder(int n, int[][] prerequisites) {
        var rt = new int[n];
        ArrayList<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (var p : prerequisites) {
            g[p[0]].add(p[1]);
            rt[p[1]]++;
        }
        var q = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (rt[i] == 0) q.offer(i);
        }
        var list = new ArrayList<Integer>();
        while (q.size() > 0) {
            --n;
            int p = q.poll();
            list.add(p);
            for (int v : g[p]) {
                if (--rt[v] == 0) {
                    q.offer(v);
                }
            }
        }
        var ans = new int[list.size()];
        for (int i = 0, j = ans.length-1; i < ans.length; i++, j--) {
            ans[i] = list.get(j);
        }
        return n == 0 ? ans : new int[0];
    }

    public static void main(String[] args) {

    }
}
