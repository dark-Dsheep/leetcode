package Algorithm.记忆化DFS;

import java.util.Arrays;

public class LC_70 {

    /*
        70. 爬楼梯
     */
    private int[] memo = new int[55];

    public int climbStairs(int n) {
        Arrays.fill(memo, -1);
        memo[1] = 1;
        memo[2] = 2;
        return dfs(n);
    }

    private int dfs(int n) {
        if (n == 0 || n == 1) return n;
        if (memo[n] != -1) return memo[n];
        memo[n] = dfs(n - 1) + dfs(n - 2); // 记忆化
        return memo[n];
    }



    public static void main(String[] args) {
    }
}
