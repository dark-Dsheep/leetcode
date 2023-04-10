package DataStructure.Tree;


import utils.TreeNode;

public class LC_1026 {

    /*
        1026. 节点与其祖先之间的最大差值
        TODO
     */
    int maxDiff = Integer.MIN_VALUE;

    public int maxAncestorDiff(TreeNode root) {
        System.out.println(dfs(root.left, root.val, Integer.MIN_VALUE));
        System.out.println(dfs(root.right, root.val, Integer.MIN_VALUE));
        return maxDiff;
    }

    private int dfs(TreeNode root, int cur, int maxDiff) {
        if (root == null) return maxDiff;
        maxDiff = Math.max(maxDiff, Math.abs(root.val - cur));
        cur = Math.min(cur, root.val);
        if (root.left != null) {
            dfs(root.left, cur, maxDiff);
        }
        if (root.right != null) {
            dfs(root.right, cur, maxDiff);
        }
        return maxDiff;
    }

    public static void main(String[] args) {

    }
}
