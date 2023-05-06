package Algorithm.树形DP;

import utils.TreeNode;

public class LC_124 {


    //LC124.二叉树最大路径和

    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    int dfs(TreeNode root) {
        if (root == null) return 0;
        int lmax = dfs(root.left);
        int rmax = dfs(root.right);
        ans = Math.max(ans, lmax + rmax + root.val);
        int mx = Math.max(lmax, rmax) + root.val; // 当前子树最大链和
        return Math.max(mx, 0);
    }

    public static void main(String[] args) {

    }
}
