package Algorithm.DP;

public class LC_740 {


//    740. 删除并获得点数

    // dp[i][0] 表示不删除i获得的最大点数
    // dp[i][1] 表示删除i获得的最大点数
    int[][] dp = new int[10010][2];
    // c[i]表示元素i出现的次数
    int[] c = new int[10010];

    public int deleteAndEarn(int[] nums) {
        for (int x : nums) c[x]++;
        int ans = 0;
        dp[1][0] = 0;
        dp[1][1] = c[1];
        for (int i = 2; i <= 10000; i++) {
            // 当前i不删除,i-1可以删除,也可以不删除
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            // 当前i删除,i-1必须不删除
            dp[i][1] = dp[i - 1][0] + i * c[i];
            ans = Math.max(dp[i][0], dp[i][1]);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
