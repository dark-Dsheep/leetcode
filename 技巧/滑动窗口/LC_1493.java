package 技巧.滑动窗口;


public class LC_1493 {

    /*
        1493. 删掉一个元素以后全为 1 的最长子数组
     */

    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int res = Integer.MIN_VALUE;
        int pre = 0, len = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                len++;
            } else {
                // 前一段 + 当前段 求max
                res = Math.max(res, pre + len);
                pre = len;
                len = 0;    // len清零
            }
        }
        // 数组全为1
        if (res == Integer.MIN_VALUE) {
            return nums.length - 1;
        }
        // 计算最后一段
        res = Math.max(res, pre + len);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 1, 0, 1, 1, 0, 1};
        System.out.println(new LC_1493().longestSubarray(nums));
    }
}
