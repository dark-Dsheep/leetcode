package Algorithm.Dp;

public class LC_918 {

//    918. 环形子数组的最大和

    public int maxSubarraySumCircular(int[] nums) {
        // 两次Kadane求解
        // case1: 子数组最大和在原数组中   => ans=最大子段和
        // case2: 子数组最大和在环形数组中 => ans=数组总和 - 最小子段和
        int n = nums.length;
        int max = nums[0], min = nums[0], sum = nums[0];
        var dp1 = new int[n];
        var dp2 = new int[n];
        dp1[0] = dp2[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp1[i] = Math.max(dp1[i - 1] + nums[i], nums[i]);
            dp2[i] = Math.min(dp2[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp1[i]);
            min = Math.min(min, dp2[i]);
            sum += nums[i];
        }
        if (max < 0) return max; // 数组全为负数的情况
        // System.out.println("ans2->" + max);
        // System.out.println("ans1->" + (sum - min));
        return Math.max(max, sum - min);
    }

    // O(1)空间
    public int maxSubarraySumCircular2(int[] nums) {
        // 两次Kadane求解
        // case1: 子数组最大和在原数组中   => ans=最大子段和
        // case2: 子数组最大和在环形数组中 => ans=数组总和 - 最小子段和
        int n = nums.length;
        // 空间优化
        int preMax = nums[0], preMin = nums[0], sum = nums[0];
        int max = preMax, min = preMin;
        for (int i = 1; i < n; i++) {
            preMax = Math.max(preMax + nums[i], nums[i]);
            preMin = Math.min(preMin + nums[i], nums[i]);
            max = Math.max(max, preMax);
            min = Math.min(min, preMin);
            sum += nums[i];
        }
        if (max < 0) return max; // 数组全部为负数的情况
        return Math.max(max, sum - min);
    }

    public static void main(String[] args) {

    }
}
