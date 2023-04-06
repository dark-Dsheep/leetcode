package Algorithm.MemoSearch;

public class LC_552 {


    /*
        552. 学生出勤记录 II
     */
    private int mod = (int) 1e9 + 7;
    private int[][][] memo;

    public int checkRecord(int n) {
        memo = new int[n + 1][2][3];
        return dfs(0, 0, 0, n);
    }

    /**
     *
     * @param acnt      当前缺勤(A)的数量
     * @param lcnt      当前连续迟到(L)的数量
     * @param day       当前是第几天
     * @param n         当前还有几天可选择
     * @return
     */
    private int dfs(int acnt, int lcnt, int day, int n) {
        if (acnt >= 2) return 0;
        if (lcnt >= 3) return 0;
        if (day >= n) return 1;
        // 天数,缺勤数,连续迟到数 作为记忆化key
        if (memo[day][acnt][lcnt] != 0) {
            return memo[day][acnt][lcnt];
        }
        int res = 0;
        // 重点: L必须是连续的,如果不选择L,则清除L的计数
        res = dfs(acnt + 1, 0, day + 1, n)       % mod;
        res = (res + dfs(acnt, lcnt + 1, day + 1, n))  % mod;
        res = (res + dfs(acnt, 0, day + 1, n))         % mod;
        memo[day][acnt][lcnt] = res;    // 记忆化
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new LC_552().checkRecord(10101));
    }

}
