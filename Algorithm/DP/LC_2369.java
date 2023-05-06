package Algorithm.DP;

public class LC_2369 {

//    2369. 检查数组是否存在有效划分
    int[] a;
    Boolean[] memo = new Boolean[100010];
    public boolean validPartition(int[] nums) {
        a = nums;
        // DP做法
        // var dp = new boolean[n+1];
        // var a = new int[n+1];
        // for (int i = 1; i <= n; i++) {
        //     a[i] = nums[i-1];
        // }
        // dp[0] = true;
        // dp[2] = a[1] == a[2]; // 看看第一组 2个元素是否满足划分方案1 -> 恰好两个相等元素
        // for (int i = 3; i <= n; i++) {
        //     dp[i] = dp[i] || (dp[i-2] && a[i] == a[i-1]); // 划分方案1
        //     dp[i] = dp[i] || (dp[i-3] && a[i] == a[i-1] && a[i-1] == a[i-2]); // 划分方案2
        //     dp[i] = dp[i] || (dp[i-3] && a[i] - a[i-1] == 1 && a[i-1] - a[i-2] == 1); // 划分方案3
        // }
        // return dp[n];

        return dfs(0);
    }

    // 记忆化DFS
    boolean dfs(int pos) {
        if (pos >= a.length) return true;
        if (memo[pos] != null) return memo[pos];
        var ans = false;
        if (pos + 1 < a.length && a[pos] == a[pos+1]) {
            ans |= dfs(pos + 2);
        }
        if (pos + 2 < a.length && a[pos] == a[pos+1] && a[pos] == a[pos+2]) {
            ans |= dfs(pos + 3);
        }
        if (pos + 2 < a.length && a[pos+1] - a[pos] == 1 && a[pos+2] - a[pos+1] == 1) {
            ans |= dfs(pos + 3);
        }
        memo[pos] = ans;
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {10, 20, 30};
        System.out.println(new LC_2369().validPartition(nums));
    }
}
