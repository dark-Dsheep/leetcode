package Skill.SlidingWindow;

public class LC_209 {

//    209. 长度最小的子数组
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int i = 0, j = 0, sum = 0;
        int ans = 0x3f3f3f;
        while (i < n) {
            sum += nums[i];
            while (sum >= target) {
                ans = Math.min(ans, i - j + 1);
                sum -= nums[j++];
            }
            i++;
        }
        return ans == 0x3f3f3f ? 0 : ans;
    }

    public static void main(String[] args) {

    }
}
