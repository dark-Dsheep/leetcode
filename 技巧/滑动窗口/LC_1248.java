package 技巧.滑动窗口;

public class LC_1248 {


    /*
        1248. 统计「优美子数组」
     */

    public int numberOfSubarrays(int[] nums, int k) {
        // 恰好k个奇数数字子数组 = 最大k个奇数数字子数组 - 最大k-1个奇数数字子数组
        return getSubArr(nums, k) - getSubArr(nums, k - 1);
    }

    private int getSubArr(int[] nums, int k) {
        int l = 0, r = 0, cnt = 0;
        int res = 0;
        while (r < nums.length) {
            cnt += (nums[r] & 1);
            while (cnt > k) {
                cnt -= (nums[l] & 1);
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
