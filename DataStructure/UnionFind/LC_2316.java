package DataStructure.UnionFind;

import java.util.HashMap;

public class LC_2316 {


    /*
        2316. 统计无向图中无法互相到达点对数
     */

    private int[] father;

    public long countPairs(int n, int[][] edges) {
        // 联通分量 ==>  3
        // (3-1) * 4 + (3 -1) * 2 + (3 - 1) * 1
        // 8 + 4 + 2 = 14
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
        for (int[] e : edges) {
            union(e[0], e[1]);
        }
        // 统计每个连通块大小
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(i);
            map.put(root, map.getOrDefault(root, 0) + 1);
        }
        long res = 0;
        for (int key : map.keySet()) {
            int num = map.get(key);
            res += (long) num * (n - num);
        }
        //
        return res / 2;
    }

    int find(int x) {
        while(father[x] != x) {
            father[x] = father[father[x]];
            x = father[x];
        }
        return x;
    }

    void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot) return;
        father[yRoot] = xRoot;
    }

    public static void main(String[] args) {

    }
}
