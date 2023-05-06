package Algorithm.记忆化DFS;

public class LC_1269 {

    /*
        1269. 停在原地的方案数
     */
    private int mod = (int) 1e9 + 7;
    private Integer[][] memo = new Integer[510][510];

    public int numWays(int steps, int arrLen) {
        return dfs(0, steps, arrLen);
    }

    // 记忆化搜索
    private int dfs(int cur, int steps, int arrLen) {
        if (cur < 0 || cur >= arrLen) return 0;
        if (steps == 0) {
            if (cur == 0) return 1;
            else          return 0;
        }
        if (memo[cur][steps] != null) {
            return memo[cur][steps];
        }
        // 搜索三种状态: 向右 不动 向左
        int res = 0;
        res = (res + dfs(cur + 1, steps - 1, arrLen)) % mod;
        res = (res + dfs(cur, steps - 1, arrLen))          % mod;
        res = (res + dfs(cur - 1, steps - 1, arrLen)) % mod;
        memo[cur][steps] = res; // 记忆化
        return res;
    }

    public static void main(String[] args) {


    }
}
