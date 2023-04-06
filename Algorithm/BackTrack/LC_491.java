package Algorithm.BackTrack;

import java.util.ArrayList;
import java.util.List;

public class LC_491 {


    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[] a;

//    491. 递增子序列

    public List<List<Integer>> findSubsequences(int[] nums) {
        a = nums;
        dfs(0, -0x3f3f);
        return ans;
    }

    void dfs(int start) {
        if (path.size() > 1) ans.add(new ArrayList<>(path));
        if (start >= a.length) return;
        var used = new boolean[210];
        for (int i = start; i < a.length; i++) {
            if (path.size() > 0 && a[i] < path.get(path.size() - 1) || used[a[i] + 100]) continue;
            path.add(a[i]);
            used[a[i] + 100] = true;
            dfs(i + 1);
            path.remove(path.size() - 1);
            used[a[i] + 100] = false;
        }
    }

    void dfs(int i, int pre) {
        if (i >= a.length) {
            if (path.size() > 1) ans.add(new ArrayList<>(path));
            return;
        }
        // 选择a[i]
        if (a[i] >= pre) {
            path.add(a[i]);
            dfs(i + 1, a[i]);
            // 恢复现场
            path.remove(path.size() - 1);
        }
        // 不选择a[i]
        if (a[i] != pre) dfs(i + 1, pre);
    }

    public static void main(String[] args) {
        int[] nums = {4, 6, 7, 7};
        System.out.println(new LC_491().findSubsequences(nums));
    }
}
