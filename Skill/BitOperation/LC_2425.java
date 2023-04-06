package Skill.BitOperation;

public class LC_2425 {

    public int xorAllNums(int[] nums1, int[] nums2) {
        // 找规律
        // L1 = nums1.length, L2 = nums2.length
        // 1.L1 % 2 == 0,L2 % 2 == 0 nums1 异或 nums2的和等于 0
        // 2.L1 % 2 == 1 nums1 异或 nums2的和等于 nums2的所有数字异或
        // 2.L2 % 2 == 1 nums1 异或 nums2的和等于 nums1的所有数字异或
        int l1 = nums1.length;
        int l2 = nums2.length;
        int res = 0;
        if (l2 % 2 == 1) {
            for (int x : nums1) res ^= x;
        }
        if (l1 % 2 == 1) {
            for (int x : nums2) res ^= x;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
