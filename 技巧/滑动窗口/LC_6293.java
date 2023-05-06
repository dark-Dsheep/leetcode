package 技巧.滑动窗口;

import java.util.HashMap;

public class LC_6293 {

    /*
    6293. 统计好子数组的数目
     */

    public long countGood(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long res = 0;
        int l = 0, r = 0;
        int cur = 0; // 对子
        while (r < nums.length) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            if (map.get(nums[r]) > 1) {
               cur += map.get(nums[r]) - 1;
            }
            while (cur >= k) {
                res += nums.length - r;
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) != 0) {    // 左边移除的对答案有贡献的元素
                    cur -= map.get(nums[l]);
                }
                l++;
            }
            r++;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 3, 2, 2, 4};
        int k = 2;
        System.out.println(new LC_6293().countGood(nums, k));
    }
}
