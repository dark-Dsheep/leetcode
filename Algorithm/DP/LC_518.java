package Algorithm.DP;

public class LC_518 {


//    518. 零钱兑换 II

    Integer[][] memo = new Integer[310][5010];

    public int change(int amount, int[] coins) {
        return dfs(coins, 0, amount);
    }

    int dfs(int[] coins, int i, int amount) {
        if (i >= coins.length) return amount == 0 ? 1 : 0;
        if (amount < 0) return 0;
        if (amount == 0) return 1;
        if (memo[i][amount] != null) return memo[i][amount];
        int ans = 0;
        // 选第i个
        ans += dfs(coins, i, amount - coins[i]);
        // 不选第i个
        ans += dfs(coins, i + 1, amount);
        memo[i][amount] = ans; // 记忆化
        return ans;
    }

    public static void main(String[] args) {

    }
}
