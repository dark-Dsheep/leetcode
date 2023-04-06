package Algorithm.BackTrack;

public class LC_1774 {


//    1774. 最接近目标价格的甜点成本


    int target;
    int ans = -1;

    public int closestCost(int[] b, int[] t, int target) {
        this.target = target;
        for (int x : b) {
            dfs(t, 0, x);
        }
        return ans;
    }

    void dfs(int[] t, int i, int sum) {
        if (i == t.length) {
            // 更新最低成本
            if (ans == -1 || abs(sum, target) < abs(ans, target) || check(sum, ans, target)) {
                ans = sum;
            }
            return;
        }
        if (ans == target) return;
        dfs(t, i + 1, sum);             // 不选
        dfs(t, i + 1, sum + t[i]);      // 选一个
        dfs(t, i + 1, sum + t[i] * 2);  // 选两个
    }

    boolean check(int ans, int sum, int target) {
        return abs(ans, target) == abs(sum, target) && ans < sum;
    }

    int abs(int x, int y) {
        return Math.abs(x - y);
    }

    public static void main(String[] args) {
        int[] baseCosts = {3, 10};
        int[] toppingCosts = {2, 5};
        int target = 9;
        System.out.println(new LC_1774().closestCost(baseCosts, toppingCosts, target));
    }
}
