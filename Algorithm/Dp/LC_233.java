package Algorithm.Dp;

import java.util.Arrays;

public class LC_233 {

    /*
        233. 数字 1 的个数
     */

    private int[][] memo = new int[15][15];
    private int[] num = new int[15];

    // 数位DP
    public int countDigitOne(int n) {
        for (var m : memo) {
            Arrays.fill(m, -1);
        }
        return solve(n);
    }

    /**
     *
     * @param pos       当前位
     * @param cnt1      当前1个数
     * @param isLimit     最高位是否受到限制
     * @return
     */
    private int dfs(int pos, int cnt1, boolean isLimit) {
        if (pos == 0) return cnt1;
        if (!isLimit && memo[pos][cnt1] != -1) {
            return memo[pos][cnt1];
        }
        // 当前最高位是否受到限制
        int up = isLimit ? num[pos] : 9;
        int res = 0;
        for (int i = 0; i <= up; i++) {
            res += dfs(pos - 1, cnt1 + (i == 1 ? 1 : 0), i == up && isLimit);
        }
        if (!isLimit) memo[pos][cnt1] = res;
        return res;
    }

    private int solve(int n) {
        int pos = 0;
        while (n != 0) {
            num[++pos] = n % 10; // 最高位在第一位
            n /= 10;
        }
        // 从最高位开始填 ...百位,十位,个位
        return dfs(pos, 0, true);
    }


    public static void main(String[] args) {

        System.out.println(new LC_233().countDigitOne(20));
    }
}
