package 技巧.滑动窗口;

import java.util.HashMap;

public class LC_1695 {

    /*
        1695. 删除子数组的最大得分
     */
    public int maximumUniqueSubarray(int[] nums) {
        int l = 0, r = 0;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        while (r < nums.length) {
            sum += nums[r];
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while (map.get(nums[r]) > 1) { // 缩短窗口
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) map.remove(nums[l]);
                sum -= nums[l];
                l++;
            }
            res = Math.max(res, sum);
            r++;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
