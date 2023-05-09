package 困难题训练;

public class LC_1420 {

    int mod = 1000000007;
    int m = 0;
    Integer[][][] memo = new Integer[51][101][51];

//    1420. 生成数组 Rating(2176)

    public int numOfArrays(int n, int m, int k) {
        this.m = m;
        // 1个大小为n的数组,最大不能超过m 求能够生成多少个这样的数组
        return dfs(n, 0, k);
    }

    int dfs(int n, int preMax, int k) {
        if (n == 0 && k == 0) return 1;
        // 两种非法case
        // 1.search_cost没用光 但是生成数组的大小已经等于n
        // 2.search_cost用光 但是生成数组的大小不等于n
        if (n == 0 || k < 0) return 0;
        if (memo[n][preMax][k] != null) {
            return memo[n][preMax][k];
        }
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            if (i > preMax) {
                ans += dfs(n-1, i, k-1); // 搜索代价-1
            } else {
                ans += dfs(n-1, preMax, k);
            }
            ans %= mod;
        }
        return memo[n][preMax][k] = ans;
    }

    public static void main(String[] args) {

        int n = 2;
        int m = 3;
        int k = 1;
        System.out.println(new LC_1420().numOfArrays(n, m, k));
    }
}
