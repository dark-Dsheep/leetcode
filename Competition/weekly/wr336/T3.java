package Competition.weekly.wr336;

import java.util.HashMap;

public class T3 {

    public long beautifulSubarrays(int[] nums) {
        // 减去 2^k -> 相当于把1变成0
        // 修改的是同一个bit位的1
        // 每次操作把同一个bit位的1变成0 -> 每次修改两个1
        // 需要偶数个1变成0
        // 异或 1^1=0
        // 异或和=0的子数组的个数
        long ans = 0L;
        var map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        int s = 0;
        for (int num : nums) {
            s ^= num;
            ans += map.getOrDefault(s, 0);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {4, 3, 1, 2, 4};
        System.out.println(new T3().beautifulSubarrays(nums));
    }
}
