package Competition.周赛补题;

public class LC_6419 {

    // 6419. 使二叉树所有路径值相等的最小代价
    int ans = 0;
    int n;
    public int minIncrements(int n, int[] cost) {
        this.n = n;
        dfs(0, cost);
        return ans;
    }

    int dfs(int i, int[] cost) {
        if (i >= n) return 0;
        int l = dfs(i * 2 + 1, cost);
        int r = dfs(i * 2 + 2, cost);
        // 将l, r变为其中一个最大的值, (2, 3) -> (3, 3)
        ans += Math.max(l, r) - Math.min(l, r); //
        cost[i] += Math.max(l, r);
        return cost[i];
    }

    public static void main(String[] args) {

    }
}
