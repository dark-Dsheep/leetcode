package Competition.biweekly.bw99;

import java.util.List;

public class T4 {

    public int rootCount(int[][] edges, int[][] guesses, int k) {
        // 换根dp
        // 1. 把以0为根的猜对次数算出来 cnt0  dfs
        // 2. 再跑一次 dfs
        // cnt
        // 0 -> 1
        // cnt -> (0, 1) in map + (1, 0) int map
        List<Integer>[] g = new List[edges.length + 1];
        for (var e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        return -1;
    }


    public static void main(String[] args) {

    }
}
