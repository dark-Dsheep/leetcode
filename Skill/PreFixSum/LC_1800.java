package Skill.PreFixSum;

public class LC_1800 {


    /*
        LC1800.  最大升序子数组和
     */
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n];
        preSum[0] = 0;
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int res = nums[0];
        int j = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                res = Math.max(res, preSum[i] - preSum[j] + nums[i]);
            } else {
                res = Math.max(res, nums[i]);
                j = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {10, 20, 30, 5, 10, 50};
        System.out.println(new LC_1800().maxAscendingSum(nums));
    }
}
