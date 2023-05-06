package Algorithm.DP;

public class LC_377 {

    /*
        377. 组合总和 Ⅳ
     */
    private Integer[] memo = new Integer[1010];

    public int combinationSum4(int[] nums, int target) {
        return dfs(nums, target);
    }

    // 记忆化搜索
    private int dfs(int[] nums, int target) {
        if (target < 0) return 0;  // 非法组合
        if (target == 0) return 1; // 合法组合
        if (memo[target] != null) {
            return memo[target];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target - nums[i] < 0) continue; // 剪枝
            res += dfs(nums, target - nums[i]);
        }
        memo[target] = res; // 记忆化
        return res;
    }

    public static void main(String[] args) {

    }
}
