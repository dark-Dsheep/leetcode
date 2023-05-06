package 技巧.滑动窗口;

import java.util.HashMap;

public class LC_2537 {

//    2537. 统计好子数组的数目
    public long countGood(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        int l = 0, r = 0, pairs = 0, len = nums.length;
        long ans = 0;
        // 扩展右边界,计数多map[nums[r]]组
        while (r < len) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            if (map.get(nums[r]) > 1) {
                pairs += map.get(nums[r]) - 1;
            }
            // 如果满足条件则从 [l,r]至[l,len]的均符合条件,答案加上len - r + 1
            // 同时尝试收缩左边界,计数减少map[nums[l]]组
            while (pairs >= k) {
                ans += len - r;
                map.put(nums[l], map.get(nums[l]) - 1);
                pairs -= map.get(nums[l]);
                l++;
            }
            r++;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
