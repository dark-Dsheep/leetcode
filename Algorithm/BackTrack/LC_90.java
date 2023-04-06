package Algorithm.BackTrack;

import java.util.*;

public class LC_90 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // 排个序 相同的数字挨在一起
        var path = new ArrayDeque<Integer>(nums.length);
        dfs(nums, 0, path);
        return res;
    }

    private void dfs(int[] nums, int idx, Deque<Integer> path) {
        res.add(new ArrayList<>(path));

        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) { // 剪个枝咯
                continue;
            }
            path.addLast(nums[i]);
            dfs(nums, i + 1, path);
            path.removeLast();
        }

    }

    public static void main(String[] args) {

    }
}
