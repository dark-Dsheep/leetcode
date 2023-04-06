package Skill.SlidingWindow;

import java.util.TreeMap;

public class LC_1438 {


    /*
        1438. 绝对差不超过限制的最长连续子数组
     */
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        int l = 0, r = 0;
        int res = 0;
        while (r < nums.length) {
            tmap.put(nums[r], tmap.getOrDefault(nums[r], 0) + 1);
            // 子数组的最大绝对值超过 limit 缩小窗口
            while (Math.abs(tmap.firstKey() - tmap.lastKey()) > limit) {
                tmap.put(nums[l], tmap.get(nums[l]) - 1);
                if (tmap.get(nums[l]) == 0) tmap.remove(nums[l]);
                l++;
            }
            // 记录最大子数组长度
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {8, 2, 4, 7};
        int limit = 4;
        System.out.println(new LC_1438().longestSubarray(nums, limit));
    }
}
