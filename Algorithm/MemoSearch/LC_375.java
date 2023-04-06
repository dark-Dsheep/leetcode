package Algorithm.MemoSearch;

public class LC_375 {


    /*
        375. 猜数字大小 II
     */
    private int[][] memo;

    public int getMoneyAmount(int n) {
        memo = new int[n+1][n+1];
        return dfs(1, n);
    }

    private int dfs(int l, int r) {
        if (l >= r) return 0;
        if (memo[l][r] != 0) return memo[l][r];
        int ans = 0x3f3f3f;
        for (int x = l; x <= r; x++) {
            // 当前需要cost才能猜中数字
            int cost = x + Math.max(dfs(l, x-1), dfs(x+1, r));
            // 选择最小花费
            ans = Math.min(ans, cost);
        }
        // 记忆化
        memo[l][r] = ans;
        return ans;
    }

    public static void main(String[] args) {

    }
}
