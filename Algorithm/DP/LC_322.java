package Algorithm.DP;

public class LC_322 {


//    322. 零钱兑换

    int[] memo = new int[10010];

    public int coinChange(int[] coins, int amount) {
        return dfs(coins, amount);
    }

    public int dfs(int[] coins, int amount) {
        if (amount == 0) return 0; // 合法方案
        if (amount < 0) return -1; // 非法方案
        if (memo[amount] != 0) return memo[amount];
        int ans = 0x3f3f3f;
        for (int coin : coins) {
            int sub = dfs(coins, amount - coin);
            if (sub != -1) ans = Math.min(ans, sub + 1);
        }
        ans = ans == 0x3f3f3f ? -1 : ans;
        memo[amount] = ans;
        return ans;
    }

    public static void main(String[] args) {

    }
}
