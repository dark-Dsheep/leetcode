package Skill.PreFixSum;

public class LC_1685 {

    /*
        1685. 有序数组中差绝对值之和
        TODO
     */

    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n];
        int[] sufSum = new int[n];
        preSum[0] = 0;
        sufSum[n - 1] = 0;
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + Math.abs(preSum[i - 1] - nums[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            sufSum[i] = sufSum[i + 1] + Math.abs(sufSum[i + 1] - nums[i]);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = preSum[i] + sufSum[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 6, 8, 10};
        System.out.println(new LC_1685().getSumAbsoluteDifferences(nums));
    }
}
