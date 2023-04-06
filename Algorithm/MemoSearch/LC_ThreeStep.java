package Algorithm.MemoSearch;

public class LC_ThreeStep {

    /*
        面试题 08.01. 三步问题
     */

    private long[] memo = new long[1000010];

    public int waysToStep(int n) {
        return (int) dfs(n);
    }

    private long dfs(int n) {
        if (n == 0 || n == 1) return 1;
        if (n == 2) return 2;
        if (memo[n] != 0) return memo[n];
        long res = 0;
        res = (res + dfs(n - 1) + dfs(n - 2) + dfs(n - 3)) % 1000000007;
        memo[n] = res;
        return res;
    }


    public static void main(String[] args) {

    }
}
