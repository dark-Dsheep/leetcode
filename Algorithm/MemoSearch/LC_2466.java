package Algorithm.MemoSearch;

import java.util.Arrays;

public class LC_2466 {

//    2466. 统计构造好字符串的方案数

    int mod = (int) 1e9 + 7;
    int[] memo;

    public int countGoodStrings(int low, int high, int zero, int one) {
        this.memo = new int[high + 1];

        int ans = 0;
        Arrays.fill(memo, -1);
        for (int i = low; i <= high; i++) {
            ans = (ans + dfs(i, zero, one)) % mod;
        }
        return ans;
    }

    int dfs(int cur, int zero, int one) {
        if (cur < 0) return 0;
        if (cur == 0) return 1; // 合法方案
        if (memo[cur] != -1) return memo[cur];
        int ans = 0;
        // 每次添加'0'zero次 或者添加'1'one次
        ans = (ans + dfs(cur - zero, zero, one)) % mod;
        ans = (ans + dfs(cur - one, zero, one)) % mod;
        memo[cur] = ans;
        return ans;
    }

    public static void main(String[] args) {

    }
}
