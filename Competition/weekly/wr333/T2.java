package Competition.weekly.wr333;

public class T2 {

    // 回溯 枚举是 + 2^k 还是 - 2^k
    // lowbit  = x & -x

    int[] memo = new int[200000];

    // 思路
    // 把 n 看成二进制数，那么最小的比特 1 是需要消除的，
    // 设它对应的数字为 lowbit
    // 消除方法可以加上 lowbit，或者减去 lowbit

    public int minOperations(int n) {
        return dfs(n);
    }

    int dfs(int n) {
        if ((n & (n - 1)) == 0) return 1;
        if (memo[n] != 0) return memo[n];
        int lb = lowbit(n);
        int ans = 1;
        ans += Math.min(dfs(n + lb), dfs(n - lb));
        memo[n] = ans; // 记忆化
        return ans;
    }

    // 求 x的二进制位 从右至左的第一个1的位置
    int lowbit(int x) {
        return x & -x;
    }

    public static void main(String[] args) {

    }
}
