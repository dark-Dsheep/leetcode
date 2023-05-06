package Algorithm.树形DP;

import utils.TreeNode;

public class LC_543 {


    //543. 二叉树的直径

    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    // 枚举每个节点
    int dfs(TreeNode root) {
        if (root == null) return -1; // 下面 +1后，对于叶子节点的lmax就为0
        int lmax = dfs(root.left) + 1; // 左子树最大链长+1
        int rmax = dfs(root.right) + 1;// 右子树最大链长+1
        ans = Math.max(ans, lmax + rmax); // 两条链拼接路径
        return Math.max(lmax, rmax); // 返回当前子树最大链长
    }



    public static void main(String[] args) {

    }
}
