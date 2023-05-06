package 技巧.滑动窗口;

public class LC_992 {

    /*
        992. K 个不同整数的子数组
     */
    public int subarraysWithKDistinct(int[] nums, int k) {
        // 恰好k个不同整数的子数组 = 最大k个不同整数的子数组 - 最大k-1个不同整数的子数组
        int Max = 0;
        for (int x : nums) Max = Math.max(Max, x);
        return getSubArr(nums, k, Max) - getSubArr(nums, k - 1, Max);
    }

    private int getSubArr(int[] nums, int k, int Max) {
        int l = 0, r = 0;
        int res = 0;
        int[] map = new int[Max + 1];
        int m = 0;
        // HashMap<Integer, Integer> map = new HashMap<>();
        while (r < nums.length) {
            map[nums[r]]++;
            if (map[nums[r]] == 1) m++;
            // map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            // while (map.size() > k) {
            //     map.put(nums[l], map.get(nums[l]) - 1);
            //     if (map.get(nums[l]) == 0) map.remove(nums[l]);
            //     l++;
            // }
            while (m > k) {
                map[nums[l]]--;
                if (map[nums[l]] == 0) m--;
                l++;
            }
            res += r - l + 1;
            r++;
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 2, 3};
        int k = 2;
        System.out.println(new LC_992().subarraysWithKDistinct(nums, k));
    }
}
