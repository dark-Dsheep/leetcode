package Algorithm.DP;

import java.util.Arrays;

public class LC_600 {

    /*
        600. 不含连续1的非负整数
     */

    private char[] num;
    private int[][] memo;

    public int findIntegers(int n) {
        num = Integer.toBinaryString(n).toCharArray();
        int m = num.length;
        memo = new int[m][2];
        for (var me : memo) {
            Arrays.fill(me, -1);
        }
        return dfs(0, false,  true);
    }

    // 数位DP模板
    private int dfs(int pos, boolean pre1, boolean isLimit) {
        if (pos == num.length) return 1;
        int state = pre1 ? 1 : 0;
        if (!isLimit && memo[pos][state] != -1) {
            return memo[pos][state];
        }
        int up = isLimit ? num[pos] - '0' : 1;
        int res = 0;
        for (int i = 0; i <= up; i++) {
            if (i == 1 && pre1) continue;
            res += dfs(pos + 1, i == 1, i == up && isLimit);
        }
        if (!isLimit) memo[pos][state] = res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LC_600().findIntegers(5));
    }
}
