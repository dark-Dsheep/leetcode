package Algorithm._树形DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_2246 {


//    2246. 相邻字符不同的最长路径


    List<Integer>[] g;
    String ss;
    int ans = 0;

    // 树形直径DP
    public int longestPath(int[] parent, String s) {
        ss = s;
        g = new ArrayList[parent.length];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 1; i < parent.length; i++) {
            g[parent[i]].add(i);
            g[i].add(parent[i]);
        }
        dfs(0, -1);
        return ans + 1;
    }

    int dfs(int x, int fa) {
        int x_max = 0;
        for (int y : g[x]) {
            if (y == fa) continue;
            int y_max = dfs(y, x) + 1;
            if (ss.charAt(y) != ss.charAt(x)) {
                ans = Math.max(ans, x_max + y_max);
                x_max = Math.max(x_max, y_max);
            }
        }
        return x_max;
    }

    public static void main(String[] args) {

    }
}
