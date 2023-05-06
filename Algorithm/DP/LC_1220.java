package Algorithm.DP;

public class LC_1220 {

    /*
    1220. 统计元音字母序列的数目
     */
    private int mod = (int) 1e9 + 7;
    private char[] chars = {'a', 'e', 'i', 'o', 'u'};
    private int[][] memo;

    // 类似题目 LC935. 骑士拨号器
    public int countVowelPermutation(int n) {
        memo = new int[n + 1][5];
        var res = 0;
        for (var i = 0; i <= 4; i++) {
            res = (res + dfs(n - 1, i)) % mod;
        }
        return res;
    }

    private int dfs(int n, int idx) {
        if (n == 0) return 1;
        if (memo[n][idx] != 0) return memo[n][idx];
        var cc = chars[idx];
        var res = 0;
        if (cc == 'a') {
            res = (res + dfs(n - 1, 4)) % mod; // u->a
            res = (res + dfs(n - 1, 1)) % mod; // e->a
            res = (res + dfs(n - 1, 2)) % mod; // i->a
        } else if (cc == 'e') {
            res = (res + dfs(n - 1, 0)) % mod; // a->e
            res = (res + dfs(n - 1, 2)) % mod; // i->e
        } else if (cc == 'i') {
            res = (res + dfs(n - 1, 1)) % mod; // e->i
            res = (res + dfs(n - 1, 3)) % mod; // o->i
        } else if (cc == 'o') {
            res = (res + dfs(n - 1, 2)) % mod; // i->o
        } else if (cc == 'u') {
            res = (res + dfs(n - 1, 2)) % mod; // i->u
            res = (res + dfs(n - 1, 3)) % mod; // o->u
        }
        memo[n][idx] = res; // 记忆化
        return res;
    }

    public static void main(String[] args) {

    }
}
