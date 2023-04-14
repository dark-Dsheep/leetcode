package Algorithm._记忆化DFS;

public class LC_1233 {

//    1223. 掷骰子模拟

    private int mod = (int) 1e9 + 7;
    private int[] max = new int[7];
    private Integer[][][] memo;

    public int dieSimulator(int n, int[] rollMax) {
        for (int i = 1; i <= 6; i++) {
            max[i] = rollMax[i - 1];
        }
        memo = new Integer[7][16][5010];
        return dfs(0, 0, n);
    }


    private int dfs(int num, int cnt, int n) {
        // num连续出现的次数受到约束
        if (num != 0 && cnt > max[num]) {
            return 0;
        }
        // 一个合法组合
        if (n == 0) return 1;
        if (memo[num][cnt][n] != null) {
            return memo[num][cnt][n];
        }
        int res = 0;
        for (int i = 1; i <= 6; i++) {
            res = (res + dfs(i, i == num ? cnt + 1 : 1, n - 1)) % mod;
        }
        memo[num][cnt][n] = res; // 记忆化
        return res;
    }

    public static void main(String[] args) {
        int n = 2;
        int[] rollMax = {1, 1, 2, 2, 2, 3};
        System.out.println(new LC_1233().dieSimulator(n, rollMax));
    }
}
