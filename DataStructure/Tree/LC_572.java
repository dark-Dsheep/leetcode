package DataStructure.Tree;


import utils.TreeNode;

public class LC_572 {

//    572. 另一棵树的子树
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) return false;
        return dfs(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true; // 子结构必须完全相同
        if (p == null || q == null) return false;
        return p.val == q.val && dfs(p.left, q.left) && dfs(p.right, q.right);
    }


    public static void main(String[] args) {

    }
}
