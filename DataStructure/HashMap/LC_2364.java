package DataStructure.HashMap;

import java.util.HashMap;

public class LC_2364 {

    /*
        2364. 统计坏数对的数目
     */
    public long countBadPairs(int[] nums) {
        long n = nums.length;
        // 总数对
        long sum = n * (n - 1) / 2;
        // 1.坏数对 = 总数对 - 好数对
        // 2.将 j - i != nums[j] - nums[i] 变个形 => i - nums[i] != j - nums[j]
        // 3.注意 i - nums[i] != j - nums[j]是求的坏数对
        // 4.好数对应该是 i - nums[i] == j - nums[j]
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            int val = i - nums[i];
            sum -= map.getOrDefault(val, 0); // 如果前面存在这个值 减去好数对个数
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 3, 3};

        System.out.println(new LC_2364().countBadPairs(nums));
    }
}
