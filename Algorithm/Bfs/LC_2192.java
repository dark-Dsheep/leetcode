package Algorithm.Bfs;

import java.util.*;

public class LC_2192 {

    /*
        2192. 有向无环图中一个节点的所有祖先
     */
    boolean[] vis = new boolean[1010]; // 防止重复访问节点

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer>[] table = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            table[i] = new LinkedList<>();
        }
        for (int[] e : edges) {
            if (e.length == 0) continue;
            int from = e[0], to = e[1];
            table[to].add(from);    // 拓扑序
        }
        for (int i = 0; i < n; i++) {
            Arrays.fill(vis, false);
            if (table[i].size() == 0) {
                res.add(new ArrayList<>());
                continue;
            }
            List<Integer> list = dfs(table, new ArrayList<>(), i);
            Collections.sort(list);
            res.add(list);
        }
        return res;
    }

    private List<Integer> dfs(LinkedList<Integer>[] table, List<Integer> list, int cur) {

        for (int next : table[cur]) {
            if (!vis[next]) {
                vis[next] = true;
                list.add(next);
                dfs(table, list, next);
            }
        }
        return list;
    }

    public static void main(String[] args) {

        int n = 8;
        int[][] edgeList = {
                {0, 3}, {0, 4}, {1, 3}, {2, 4}, {2, 7}, {3, 5}, {3, 6}, {3, 7}, {4, 6}
        };
        System.out.println(new LC_2192().getAncestors(n, edgeList));
    }
}
