package Algorithm.DP;

import java.math.BigInteger;
import java.util.Arrays;

public class LC_343 {

//    343. 整数拆分

    public int integerBreak(int n) {
        var dp = new int[n + 1][n + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) { // 拆分j -> j - i, i
                if (j == i || j < i) continue;
                // 状态转移
                dp[i][j] = Math.max(i * dp[i][j - i], i * (j - i));
                if (j == n) ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    int mod = (int) 1e9 + 7;

    public int cuttingRope(int n) {
        var dp = new BigInteger[n + 1];
        Arrays.fill(dp, BigInteger.valueOf(1));
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = dp[i].max(BigInteger.valueOf((long) j * (i - j)))
                        .max(dp[i - j].multiply(BigInteger.valueOf(j)));

            }
        }
        return dp[n].mod(BigInteger.valueOf(mod)).intValue();
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(new LC_343().integerBreak(n));

        int ban = Integer.MAX_VALUE / 10;
        int x = ban * 10 + 8;
        System.out.println(x);
    }
}
