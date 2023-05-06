package 技巧.滑动窗口;

public class LC_795 {


    /*
        795. 区间子数组个数
     */
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        // 最大元素满足大于等于L小于等于R的子数组个数 = 最大元素小于等于R的子数组个数 - 最大元素小于L的子数组个数
        return getSubArr(nums, right) - getSubArr(nums, left - 1);
    }

    private int getSubArr(int[] nums, int max) {
        int l = 0, r = 0;
        int res = 0;
        while (r < nums.length) {
            if (nums[r] > max) {
                l = r + 1;
            }
            res += r - l + 1;
            r++;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
