package HardEX;

public class LC_1000 {


//    1000. 合并石头的最低成本 Rating(2423)

    Integer[][][] f = new Integer[40][40][40];
    int[] sum;
    int k;

    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if((n - 1) % (k - 1) != 0) { // 无法合并成一堆
            return -1;
        }
        this.k = k;
        sum = new int[n+1];
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + stones[i];
        }
        return dfs(0, n-1, 1);
    }

    // dfs(i,j,c) 表示将stones[i...j]合并成c堆的最低成本
    int dfs(int i, int j, int c) {
        if (c == 1) {
            return i == j ? 0 : sum[j+1] - sum[i] + dfs(i, j, k);
        }
        if (f[i][j][c] != null) return f[i][j][c];
        int ans = 0x3f3f3f;
        // 枚举哪些石头合并成一堆
        for (int m = i; m < j; m += k-1) {
            ans = Math.min(ans, dfs(i, m, 1) + dfs(m+1, j, c-1));
        }
        return f[i][j][c] = ans;
    }



    public static void main(String[] args) {

    }
}
