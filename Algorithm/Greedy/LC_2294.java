package Algorithm.Greedy;

import java.util.Arrays;

public class LC_2294 {

    /*
        2294. 划分数组使最大差为 K
     */

    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int cnt = nums.length;
        // 贪心思路
        // 维护区间最小最大值
        // cnt表示划分的块数 -> 随着区间i的增加 块数会减少
        // 当区间最小值 和最大值得差 <= k 尝试扩展区间元素个数 直到不满足maxv-minv <= k
        int maxv = nums[0], minv = nums[0];
        // 1 2 3 5 6
        for (int i = 1; i < nums.length; i++) {
            maxv = Math.max(maxv, nums[i]);
            minv = Math.min(minv, nums[i]);
            if (maxv - minv <= k) {
                cnt -= 1;
            } else {
                minv = maxv;        // 划分新的区间
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 1, 2, 5};
        int k = 2;
        System.out.println(new LC_2294().partitionArray(nums, k));
    }
}
