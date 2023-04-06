package Math;

public class LC_2541 {

    /*
        2541. 使数组中所有元素相等的最小操作数 II
     */
    public long minOperations(int[] nums1, int[] nums2, int k) {
        // 设diff[i] = nums1[i] - nums2[i],则将问题转为求diff[i]变成0的最小操作数
        // diff[i]是k的倍数, diff[i] % k = 0
        int n = nums1.length;
        long s1 = 0, s2 = 0;
        for (int num : nums1) s1 += num;
        for (int num : nums2) s2 += num;
        if (s1 != s2) return -1;

        // 特判 k = 0
        if (k == 0) {
            for (int i = 0; i < n; i++) {
                if  (nums1[i] != nums2[i]) return -1;
            }
            return 0;
        }

        long res = 0;
        for (int i = 0; i < n; i++) {
            int diff = nums1[i] - nums2[i];
            if (diff % k != 0) return -1;
            if (diff > 0) res += diff / k;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
