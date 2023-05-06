package Algorithm.DP;

import java.util.Arrays;

public class LC_650 {


    /*
        650. 只有两个键的键盘
     */
    public int minSteps(int n) {
        if (n == 1) return 0;
        // 状态定义: dp[i]表示 输入 i 个 'A' 需要使用操作的最少次数
        var dp = new int[n + 1];
        Arrays.fill(dp, 0x3f3f3f);
        dp[0] = dp[1] = 0;
        dp[2] = 2;      // 'AA' 需要对第一个'A'执行一次Copy All, 一次Paste
        for (var i = 3; i <= n; i++) {
            for (var j = 1; j < i; j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i - 1] + 1, dp[i / j] + j);
                } else {
                    dp[i] = Math.min(dp[i], dp[i - 1] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    private static final int INF = 0x3f3f3f;
    private int[][] memo = new int[1010][1010]; // 记忆化数组

    public int minSteps2(int n) {
        for (var m : memo) {
            Arrays.fill(m, INF);
        }
        return dfs(n, 1, 0);
    }

    /**
     *
     * @param n     记事本目标字符数
     * @param cnt   记事本当前字符数
     * @param pCnt  粘贴板字符数
     * @return
     */
    private int dfs(int n, int cnt, int pCnt) {
        if (cnt > n) return INF;
        if (cnt == n) return 0;
        if (memo[cnt][pCnt] != INF) {
            return memo[cnt][pCnt];
        }
        var res = INF;
        // 搜索两种状态
        // 1.将粘贴板的字符复制到记事本 Paste
        if (pCnt > 0) {
            res = Math.min(res, dfs(n, cnt + pCnt, pCnt));
        }
        // 2.复制记事本全部字符到粘贴板 CopyAll
        if (cnt != pCnt) {  // 如果 记事本字符数 和粘贴板字符数相同,则不进行复制
            res = Math.min(res, dfs(n, cnt, cnt));
        }
        memo[cnt][pCnt] = ++res;  // 记忆化
        return res;
    }

    public static void main(String[] args) {

        System.out.println(new LC_650().minSteps2(1000));
    }
}
