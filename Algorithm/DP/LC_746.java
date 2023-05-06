package Algorithm.DP;

import java.util.Arrays;

public class LC_746 {

//    746. 使用最小花费爬楼梯

    int[] memo = new int[1000];

    public int minCostClimbingStairs(int[] cost) {
        Arrays.fill(memo, 0x3f);
        return Math.min(dfs(cost, 0), dfs(cost, 1));
    }

    int dfs(int[] cost, int i) {
        if (i >= cost.length) return 0;
        if (memo[i] != 0x3f) return memo[i];
        int ans = 0;
        ans = Math.min(dfs(cost, i + 1), dfs(cost, i + 2)) + cost[i];
        memo[i] = ans;
        return ans;
    }

    public static void main(String[] args) {

    }
}
