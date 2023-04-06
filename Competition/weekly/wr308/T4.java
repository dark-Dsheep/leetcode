package Competition.weekly.wr308;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T4 {


    int[] topoSort(int k, int[][] edges) {
        List<Integer>[] g = new ArrayList[k];
        Arrays.setAll(g, e -> new ArrayList<>());
        var inDeg = new int[k];
        for (var e : edges) {
            int x = e[0] - 1;
            int y = e[1] - 1;
            g[x].add(y);
            ++inDeg[y];
        }
        var order = new ArrayList<Integer>();
        var q = new LinkedList<Integer>();
        for (int i = 0; i < k; i++) {
            if (inDeg[i] == 0) q.offer(i);
        }
        while (q.size() > 0) {
            var u = q.poll();
            order.add(u);
            for (int v : g[u]) {
                if (--inDeg[v] == 0) q.offer(v);
            }
        }
        return order.stream().mapToInt(x -> x).toArray();
    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] row = topoSort(k, rowConditions);
        int[] col = topoSort(k, colConditions);
        if (row.length < k || col.length < k) {
            return new int[][]{};
        }
        // 构造
        var pos = new int[k];
        for (int i = 0; i < k; i++) {
            pos[col[i]] = i;
        }
        var ans = new int[k][k];
        for (int i = 0; i < k; i++) {
            ans[i][pos[row[i]]] = row[i] + 1;
        }
        return ans;
    }

}
