package Algorithm.MemoSearch;

public class LC_2318 {

//    2318. 不同骰子序列的数目

    static int mod = (int) 1e9 + 7;
    static Integer[][][] memo = new Integer[10010][8][8];
    static { dfs(10000, 7, 7); } // 静态初始化


    public int distinctSequences(int n) {
        // case1 相邻数字 -> dfs过程中需要一个pre记录上一次投的数字
        // case2 xxx相等 -> dfs过程中需要记录上上个投的数字 用来判断 abs(i-j) > 2
        return dfs(n, 7, 7);
    }
    // 记忆化DFS 有点特殊 除了记录上一个选的数字 还要记录上上个选数字
    static int dfs(int n, int pre1, int pre2) {
        if (n == 0) return 1;
        if (memo[n][pre1][pre2] != null) {
            return memo[n][pre1][pre2];
        }
        int ans = 0;
        for (int x = 1; x <= 6; x++) {
            if (gcd(x, pre1) != 1) continue;        // x不能要 相邻元素gcd != 1
            if (x == pre1 || x == pre2) continue;   // x不能要 abs(i-j) < 2
            ans = (ans + dfs(n-1, x, pre1)) % mod;
        }
        memo[n][pre1][pre2] = ans;
        return ans;
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }


    public static void main(String[] args) {
        int n = 4;
        System.out.println(new LC_2318().distinctSequences(n));
    }

}
