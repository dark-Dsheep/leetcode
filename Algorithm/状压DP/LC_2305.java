package Algorithm.状压DP;

public class LC_2305 {

//    2305. 公平分发饼干
    public int distributeCookies(int[] cookies, int k) {
        // 答案和输入的顺序无关
        // 集合的划分，消耗的概念
        // 壮压dp
        // dp[i][j] -> 消耗了i个子序列，这些子序列组成了集合j
        // 同时这i个子序列的元素和的最大值的最小值为dp[i][j]
        // dp[i][j] = 枚举j的子集 s
        // min max(dp[i - 1][j ^ s], sum[s]) for s in j
        int n = cookies.length;
        var sum = new int[1<<n];
        for (int i = 1; i < 1<<n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i >> j & 1) == 1) sum[i] += cookies[j];
            }
        }
        var dp = new int[k][1<<n];
        dp[0] = sum;
        for (int i = 1; i < k; i++) {
            for (int j = 0; j < 1<<n; j++) {
                dp[i][j] = 0x3f3f3f;
                // 重点: 枚举子集
                for (int s = j; s > 0; s = (s - 1) & j) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i-1][j^s], sum[s]));
                }
            }
        }
        return dp[k - 1][(1<<n)-1];
    }

    public static void main(String[] args) {
        int[] cookies = {8, 15, 10, 20, 8};
        System.out.println(new LC_2305().distributeCookies(cookies, 2));
    }
}
