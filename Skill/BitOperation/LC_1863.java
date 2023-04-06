package Skill.BitOperation;

public class LC_1863 {


//    1863. 找出所有子集的异或总和再求和

    private int res = 0;

    public int subsetXORSum(int[] nums) {
        dfs(nums, 0, 0);
        return res;
    }

    private void dfs(int[] nums, int idx, int cur) {
        if (idx >= nums.length) {
            res += cur;
            return;
        }
        // 选择当前数字xor 不选当前数字xor
        dfs(nums, idx + 1, cur ^ nums[idx]);
        dfs(nums, idx + 1, cur);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3};
        System.out.println(new LC_1863().subsetXORSum(nums));
    }
}
