package Algorithm.Dp;

public class LC_935 {

    /*
        935. 骑士拨号器
     */

    private int mod = (int) 1e9 + 7;
    // 每个点可拨号的路径
    private int[][] paths = {{4,6},{6,8},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{2,4}};

    private int[][] memo = new int[11][5010]; // 记忆化数组

    public int knightDialer(int n) {
        var res = 0;
        // dfs 0-9的每一个拨号键
        for (var i = 0; i <= 9; i++) {
            res = (res + dfs(n - 1, i)) % mod;
        }
        return res;
    }
    // 记忆化搜索
    private int dfs(int n, int num) {
        if (n == 0) return 1;
        if (memo[num][n] != 0) return memo[num][n];
        var res = 0;
        for (var nextNum : paths[num]) {
            res = (res + dfs(n - 1, nextNum)) % mod;
        }
        memo[num][n] = res; // 记忆化
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LC_935().knightDialer(2));
    }
}
