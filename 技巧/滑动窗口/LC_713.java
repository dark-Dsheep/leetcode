package 技巧.滑动窗口;

public class LC_713 {

//    713. 乘积小于 K 的子数组
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int i = 0, j = 0, base = 1;
        int ans = 0;
        while (i < n) {
            base *= nums[i];
            while (j <= i && base >= k) {
                base /= nums[j++];
            }
            ans += i - j + 1;
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
