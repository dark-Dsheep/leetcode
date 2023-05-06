package 技巧.前缀和;

import java.util.HashMap;

public class LC_1590 {

//    1590. 使数组和能被 P 整除
    public int minSubarray(int[] nums, int p) {
        // 本题技巧 前缀和 + 哈希表 + 同余
        // arr = [3, 1, 4, 2] p=6
        // Sum(arr) = 8; 8 % p = 2 子数组 4 % p = 2
        // 设Sum(arr)=b, Sub(4) = a, b跟a同余 -> (b-a) % p == 0
        long x = 0, s = 0;
        int ans = 0x3f3f3f;
        for (int num : nums) x = (x + num) % p;
        // 从数组中找一个与x同余的 的最短子数组 (Sum(sub) - X) mod p == 0
        var map = new HashMap<Long, Integer>();
        map.put(0L, -1);
        for (int i = 0; i < nums.length; i++) {
            s = (s + nums[i]) % p;
            map.put(s, i);
            long remain = ((s - x) % p + p) % p; // 负数取模小技巧
            if (map.containsKey(remain)) {
                ans = Math.min(ans, i - map.get(remain));
            }
        }
        return ans < nums.length ? ans : -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int p = 3;
        System.out.println(new LC_1590().minSubarray(nums, p));
    }
}
