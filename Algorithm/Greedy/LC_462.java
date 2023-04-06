package Algorithm.Greedy;

import java.util.Arrays;

public class LC_462 {

//    462. 最小操作次数使数组元素相等 II

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums[(nums.length - 1) / 2];
        int ans = 0;
        // 中位数贪心 => 类似题目 LC2033. 获取单值网格的最小操作数
        for (int x : nums) {
            ans += Math.abs(x - mid);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
