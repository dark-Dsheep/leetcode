package Algorithm.DP;

public class LC_55 {


    /*
        55. 跳跃游戏
     */
    public boolean canJump(int[] nums) {
        var n = nums.length;
        var dp = new boolean[n];
        dp[0] = true;
        for (var i = 1; i < n; i++) {
            for (var j = 0; j < i; j++) {
                if (nums[j] != 0 && j + nums[j] >= i) {  // 从j开始最大长度跳到i
                    dp[i] = dp[j];
                    break;
                }
                // 上一个位置能跳的步数不为0才 判断跳1步能否跳到i
                if (nums[i - 1] != 0) {
                    dp[i] |= dp[i - 1];
                    break;
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[n - 1];
    }

    public static void main(String[] args) {

    }
}
