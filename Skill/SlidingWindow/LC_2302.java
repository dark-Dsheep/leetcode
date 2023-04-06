package Skill.SlidingWindow;

public class LC_2302 {

    /*
        2302. 统计得分小于 K 的子数组数目
     */
    public long countSubarrays(int[] nums, long k) {
        // 恰好k个窗口模板题 类似LC992
        int l = 0, r = 0;
        long sum = 0;
        long d = 0;
        long res = 0;
        while (r < nums.length) {
            sum += nums[r];
            while (sum * (r - l + 1) >= k) {
                sum -= nums[l];
                l++;
            }
            res += r - l + 1;
            r++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 3, 5};
        int k = 10;
        System.out.println(new LC_2302().countSubarrays(nums, k));
    }
}
