package Algorithm.BackTrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC_216 {

    private List<List<Integer>> res = new ArrayList<>();


    public List<List<Integer>> combinationSum3(int k, int n) {
        var path = new ArrayDeque<Integer>();
        dfs(1, k, n, path);
        return res;
    }

    private void dfs(int idx, int k, int target, Deque<Integer> path) {
        if (target == 0 && path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i <= 9; i++) {
            if (target - i < 0) break;  // 剪个枝咯
            path.addLast(i);
            dfs(i + 1, k, target - i, path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {

    }
}
