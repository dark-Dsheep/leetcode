package Algorithm.DP;

public class LC_1137 {

    int[] memo = new int[40];

    /*
        1137. 第n个斐波那契数列
     */
    public int tribonacci(int n) {
        return dfs(n, memo);
    }
    // 记忆化
    public int dfs(int n, int[] memo) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        if (memo[n] != 0) return memo[n];
        memo[n] = dfs(n - 1, memo) + dfs(n - 2, memo) + dfs(n - 3, memo);
        return memo[n];
    }


    public static void main(String[] args) {

    }
}
