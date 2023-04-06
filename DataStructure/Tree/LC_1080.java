package DataStructure.Tree;

import LeetCode.utils.TreeNode;

public class LC_1080 {

//    1080. 根到叶路径上的不足节点

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return dfs(root, 0, limit);
    }

    TreeNode dfs(TreeNode root, int pathVal, int limit) {
        if (root == null) return null;
        pathVal += root.val;
        if (root.left == null && root.right == null) { // 叶子节点
            // 判断从根节点到当前叶子节点的路径和是否小于limit
            return pathVal < limit ? null : root;
        }
        root.left = dfs(root.left, pathVal, limit);
        root.right = dfs(root.right, pathVal, limit);
        return root.left == null && root.right == null ? null : root;
    }

    public static void main(String[] args) {
    }
}
