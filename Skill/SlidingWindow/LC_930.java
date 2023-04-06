package Skill.SlidingWindow;

public class LC_930 {
    /*
        930. 和相同的二元子数组
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        if (goal == 0) {
            return getSubArr(nums, 0);
        }
        // 恰好和为goal的子数组 = 最大和为goal的子数组 - 最大和为goal-1的子数组
        return getSubArr(nums, goal) - getSubArr(nums, goal - 1);
    }

    private int getSubArr(int[] nums, int k) {
        int l = 0, r = 0;
        int sum = 0;
        int res = 0;
        while (r < nums.length) {
            sum += nums[r];
            while (sum > k) {
                sum -= nums[l];
                l++;
            }
            res += r - l + 1;
            r++;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
