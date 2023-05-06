package Algorithm.DP;

public class LC_413 {
//    413. 等差数列划分
    // 双指针做法
    public int numberOfArithmeticSlices(int[] nums) {
        // 等差数列 a1 a2 a3
        // a1 + a3 = 2 * a2
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n - 2; i++) {
            int d = nums[i + 1] - nums[i]; // 公差
            for (int j = i + 1; j < n; j++) {
                if (j - i + 1 > 2) {       // 等差数列至少3个元素
                    if (nums[j] - nums[j - 1] == d) ans++;
                    else   break;
                }
            }
        }
        return ans;
    }
    // dp
    public int numberOfArithmeticSlices2(int[] nums) {
        // 等差数列 a1 a2 a3
        // a1 + a3 = 2 * a2
        int n = nums.length;
        // 1 2 3 6 8 10 nums
        // 0 0 1 0 0 1 增量
        var dp = new int[n];
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            if (nums[i - 1] + nums[i + 1] == 2 * nums[i]) {
                dp[i] = dp[i - 1] + 1;  // 确定增量
                ans += dp[i];           // 累加
            }
        }
        // System.out.println(Arrays.toString(dp));
        return ans;
    }

    public static void main(String[] args) {

    }
}
