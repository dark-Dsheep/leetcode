package DataStructure.HashMap;

import java.util.HashMap;

public class LC_1865 {

    /*
        1865. 找出和为指定值的下标对
     */
    class FindSumPairs {
        // 将nums2的数存入map, v代表出现的次数
        private HashMap<Integer, Integer> map = new HashMap<>();
        private int[] nums1;
        private int[] nums2;

        public FindSumPairs(int[] nums1, int[] nums2) {
            this.nums1 = nums1;
            this.nums2 = nums2;
            for (int x : nums2) {
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
        }

        public void add(int index, int val) {
            map.put(nums2[index], map.get(nums2[index]) - 1); // 修改原数字的频次
            nums2[index] += val;
            map.put(nums2[index], map.getOrDefault(nums2[index], 0) + 1); // 更新新数字的频次

        }

        public int count(int tot) {
            int cnt = 0;
            // nums1[i] + nums2[j] = tot
            // nums2[j] = tot - nums1[i] -> 统计map中的数字频次
            for (int x : nums1) {
                cnt += map.getOrDefault(tot - x, 0);
            }
            return cnt;
        }
    }

    public static void main(String[] args) {

    }
}
