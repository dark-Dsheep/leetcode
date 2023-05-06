package Algorithm.DP;

public class LC_808 {

    /*
        808. 分汤
     */
    private double[][] memo;

    public double soupServings(int n) {
        if (n >= 5000) return 1;
        memo = new double[n + 1][n + 1];
        return dfs(n, n);
    }

    private double dfs(int a, int b) {
        if (a == 0 && b != 0) { // a先倒完
            return 1;
        }
        if (a == 0 && b == 0) { // ab同时倒完
            return 0.5;
        }
        if (a != 0 && b == 0) { // b先倒完
            return 0;
        }
        if (memo[a][b] != 0) {
            return memo[a][b];
        }
        double res = 0;
        res += dfs(Math.max(0, a - 100), b);
        res += dfs(Math.max(0, a - 75), Math.max(0, b - 25));
        res += dfs(Math.max(0, a - 50), Math.max(0, b - 50));
        res += dfs(Math.max(0, a - 25), Math.max(0, b - 75));
        res *= 0.25;
        memo[a][b] = res;   // 记忆化
        return res;
    }

    public static void main(String[] args) {

    }
}
