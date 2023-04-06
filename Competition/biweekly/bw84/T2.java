package Competition.biweekly.bw84;

import java.util.HashMap;

public class T2 {


    public long countBadPairs(int[] nums) {
        // j - i != nums[j] - nums[i] ==> nums[i] - i != nums[j] - j
        // 好数对 nums[i] - i == nums[j] - j
        int n = nums.length;
        long all = (long) n * (n-1) / 2;
        long good = 0;
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            int val = nums[i] - i;
            good += map.getOrDefault(val, 0);
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
//        return all - good;

        return all - good;
    }

    public static void main(String[] args) {
        System.out.println(1 << 31);
    }
}
