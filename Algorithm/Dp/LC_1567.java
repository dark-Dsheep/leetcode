package Algorithm.Dp;

import java.util.ArrayList;

public class LC_1567 {


//    1567. 乘积为正数的最长子数组长度

    public int getMaxLen(int[] nums) {
        int n = nums.length;
        //dp[i][0]表示乘积为正数的最长子数组长度
        //dp[i][1]表示乘积为负数的最长子数组长度
        var dp = new int[n][2];
        if (nums[0] > 0) dp[0][0] = 1;
        else if (nums[0] < 0) dp[0][1] = 1;
        int ans = dp[0][0];
        for (int i = 1; i < n; i++) {
            if (nums[i] < 0) {
                //当前数字是负数
                // 以i结尾负数的最大长度 = i-1结尾正数的最大长度 + 1  正负得负
                // 以i结尾正数的最大长度 = i-1结尾负数的最大长度 + 1  负负得正
                dp[i][1] = dp[i - 1][0] + 1;
                dp[i][0] = dp[i - 1][1] > 0 ? dp[i - 1][1] + 1 : 0;
            } else if (nums[i] > 0) {
                //当前数字是正数
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = dp[i - 1][1] > 0 ? dp[i - 1][1] + 1 : 0;
            } else {
                dp[i][0] = dp[i][1] = 0;
            }
            ans = Math.max(ans, dp[i][0]);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {1, -2, -3, 4};
        int[] nums1 = {0, 1, -2, -3, -4};
        var list = new ArrayList<int[]>();
        list.add(nums);
        list.add(nums1);
        for (var a : list) System.out.println(new LC_1567().getMaxLen(a));
    }
}
