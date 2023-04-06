package Algorithm.BackTrack;

import java.util.*;

public class LC_47 {


    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        if (len == 0) return res;
        Arrays.sort(nums);
        var used = new boolean[len];
        var path = new ArrayDeque<Integer>(len);
        dfs(nums, used, path);
        return res;
    }


    private void dfs(int[] nums, boolean[] used, Deque<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums,used, path);
            used[i] = false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(new LC_47().permuteUnique(nums));
    }
}
