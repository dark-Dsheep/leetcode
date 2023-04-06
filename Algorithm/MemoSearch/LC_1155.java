package Algorithm.MemoSearch;

public class LC_1155 {

    int mod = (int) 1e9 + 7;
    Integer[][] memo = new Integer[40][1010];

//    1155. 掷骰子的N种方法

    public int numRollsToTarget(int n, int k, int target) {
        return dfs(n, k, target);
    }

    private int dfs(int cnt, int k, int target) {
        if (cnt < 0 || target < 0) return 0; // 骰子用完了 或者target被减到负数
        if (cnt == 0 && target == 0) return 1; // 一种合法答案
        if (memo[cnt][target] != null) {
            return memo[cnt][target];
        }
        int res = 0;
        for (int i = 1; i <= k; i++) {
            res = (res + dfs(cnt - 1, k, target - i)) % mod;
        }
        memo[cnt][target] = res; // 记忆化
        return res;
    }

    public static void main(String[] args) {

    }
}
