package Algorithm.树形DP;

import utils.TreeNode;

public class LC_337 {

    //337. 打家劫舍 III

    public int rob(TreeNode root) {
        var ans = dfs(root);
        return Math.max(ans[0], ans[1]); // 根节点选不选取最大值
    }

    int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        var left = dfs(root.left);
        var right = dfs(root.right);
        int rob = left[1] + right[1] + root.val; // 当前选 左右子树不选
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // 当前不选 左右子树可选可不选
        return new int[]{rob, notRob};
    }


    public static void main(String[] args) {

    }
}
