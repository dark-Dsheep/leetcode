package Algorithm.MemoSearch;

public class LC_96 {

    /*
        96. 不同的二叉搜索树
     */
    private int[] memo = new int[30];

    public int numTrees(int n) {
        memo[0] = memo[1] = 1;
        return dfs(n);
    }

    private int dfs(int n) {
        if (n == 0 || n == 1) return 1;
        if (memo[n] != 0) return memo[n];
        var res = 0; // 存储中间计算结果
        for (var i = 1; i <= n; i++) {
            // 计算以i为根 左右子树的数量
            var left = dfs(i - 1);
            var right = dfs(n - i);
            res += left * right;
        }
        memo[n] = res; // 记忆化
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LC_96().numTrees(3));
    }
}
