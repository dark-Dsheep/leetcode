package Algorithm.Dfs;

import java.util.ArrayList;
import java.util.List;

public class LC_797 {


//    797. 所有可能的路径
    int[][] g;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        g = graph;
        var ans = new ArrayList<List<Integer>>();
        dfs(ans, new ArrayList<>(), 0);
        return ans;
    }

    void dfs(List<List<Integer>> ans, List<Integer> path, int cur) {
        path.add(cur);
        if (cur == g.length - 1) {
            ans.add(new ArrayList<Integer>(path));
            return;
        }
        for (var ne : g[cur]) {
            dfs(ans, path, ne);
            path.remove(path.size() - 1); // 恢复现场
        }
    }

    public static void main(String[] args) {

    }
}
