package 技巧.前缀和;

import java.util.Arrays;

public class LC_1685 {

    /*
        1685. 有序数组中差绝对值之和
     */

    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        var sum = new int[n+1]; // 前缀和数组
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
        var ans = new int[n];
        // ans[i]表示nums[i]与数组其他元素的差值之和
        // 等价于以i为分界点, 求Sum(i左边元素的元素差值之和)+Sum(i右边元素的元素差值之和)
        // left = i左边的前缀和 - 需要减去i个nums[i]
        // right = i右边的前缀和 - 需要减去n-i个nums[i]
        for (int i = 0; i < n; i++) {
            int left = Math.abs(sum[i] - i * nums[i]);
            int right = Math.abs(sum[n] - sum[i] - (n-i) * nums[i]);
            ans[i] = left + right;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 6, 8, 10};
        System.out.println(Arrays.toString(new LC_1685().getSumAbsoluteDifferences(nums)));
    }
}
