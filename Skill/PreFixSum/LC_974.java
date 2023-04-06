package Skill.PreFixSum;

import java.util.HashMap;

public class LC_974 {

//    974. 和可被 K 整除的子数组
    public int subarraysDivByK(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        int ans = 0;
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            s = (s % k + k) % k; // (a % b + b) % b -> 负数取模小技巧
            if (map.containsKey(s)) {
                ans += map.get(s);
            }
            map.merge(s, 1, Integer::sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {7, 4, -10};
        int k = 5;
        System.out.println(new LC_974().subarraysDivByK(arr, k));
    }
}
