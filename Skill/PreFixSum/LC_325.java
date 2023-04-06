package Skill.PreFixSum;

import java.util.HashMap;

public class LC_325 {

    /*
        325. 和等于 k 的最长子数组长度
     */

    public int maxSubArrayLen(int[] nums, int k) {
        // 前缀和 + 哈希表
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                int j = map.get(sum - k);
                res = Math.max(res, i - j);
            }
            // 让map存储最远的下标 使得长度最大
            if (map.containsKey(sum)) continue;
            map.put(sum, i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, 5, -2, 3};
        int k = 3;
        System.out.println(new LC_325().maxSubArrayLen(nums, k));
    }
}
