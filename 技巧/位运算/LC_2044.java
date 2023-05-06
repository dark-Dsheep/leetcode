package 技巧.位运算;

public class LC_2044 {

//    2044. 统计按位或能得到最大值的子集数目

    private int res = 0;
    private int max = 0;

    public int countMaxOrSubsets(int[] nums) {
        // nums的非空子集个数 -> 2^n - 1个
        for (int x : nums) max |= x;
        dfs(nums, 0, 0);
        return res;
    }

    private void dfs(int[] nums, int idx, int cur) {
        if (cur == max) {
            // 剪枝,or已经到达最大值,后面的数or都是这个最大值
            res += 1 << (nums.length - idx); // 2^n-i 个子集
            return;
        }
        if (idx >= nums.length) return;
        // 选择 当前数字 不选当前数字
        dfs(nums, idx + 1, cur | nums[idx]);
        dfs(nums, idx + 1, cur);
    }

    public static void main(String[] args) {

    }
}
