package 困难题训练;

public class LC_1012 {

//    1012. 至少有 1 位重复的数字 Rating(2230)


    // 数位DP
    char[] cs;
    Integer[][] memo;

    public int numDupDigitsAtMostN(int n) {
        cs = Integer.toString(n).toCharArray();
        memo = new Integer[cs.length][1<<10];
        return n - dfs(0, 0, true, false);
    }

    int dfs(int i, int mask, boolean isLimit, boolean isNum) {
        if (i == cs.length) {
            return isNum ? 1 : 0;
        }
        if (!isLimit && isNum && memo[i][mask] != null) {
            return memo[i][mask];
        }
        int ans = 0;
        if (!isNum) {
            ans = dfs(i + 1, mask, false, false);
        }
        int up = isLimit ? cs[i] - '0' : 9;
        for (int d = isNum ? 0 : 1; d <= up; ++d) {
            if ((mask >> d & 1) == 0) {
                ans += dfs(i + 1, mask | (1<<d), isLimit && d == up, true);
            }
        }
        if (!isLimit && isNum) {
            memo[i][mask] = ans;
        }
        return ans;
    }


    public static void main(String[] args) {

    }



}
