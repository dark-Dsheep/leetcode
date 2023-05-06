package Algorithm.DP;

public class LC_688 {


    /*
        688. 骑士在棋盘上的概率
     */
    private int n = 0;
    private Double[][][] memo = new Double[110][30][30]; // 记忆化数组

    public double knightProbability(int _n, int k, int row, int column) {
        n = _n;
        return dfs(row, column, 0, k) / Math.pow(8, k);
    }

    private double dfs(int x, int y, int step, int k) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return 0;
        }
        if (step == k) {     // 走了k步还停留在棋盘 合法答案
            return 1;
        }
        if (memo[step][x][y] != null) {
            return memo[step][x][y];
        }
        double res = 0;
        // 搜索八个方向
        res += dfs(x - 2, y - 1, step + 1, k);
        res += dfs(x - 2, y + 1, step + 1, k);
        res += dfs(x - 1, y + 2, step + 1, k);
        res += dfs(x + 1, y + 2, step + 1, k);
        res += dfs(x + 2, y + 1, step + 1, k);
        res += dfs(x + 2, y - 1, step + 1, k);
        res += dfs(x + 1, y - 2, step + 1, k);
        res += dfs(x - 1, y - 2, step + 1, k);
        memo[step][x][y] = res;     // 记忆化
        return res;
    }

    public static void main(String[] args) {

    }
}
