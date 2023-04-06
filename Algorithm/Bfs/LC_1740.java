package Algorithm.Bfs;

import LeetCode.utils.TreeNode;

public class LC_1740 {

    /*
        1740. 找到二叉树中的距离
     */

    public int findDistance(TreeNode root, int p, int q) {
        // 求俩个节点的LCA
        TreeNode lca = findLCA(root, p, q);
        // 边数 = dist(lca, p) + dist(lca, q);
        int dist1 = findLevel(lca, p, 0);
        int dist2 = findLevel(lca, q, 0);
        System.out.println(dist1);
        System.out.println(dist2);
        return dist1 + dist2;
    }

    public int findLevel(TreeNode root, int p, int level) {
        if (root == null) return -1;
        if (root.val == p) return level;
        int lev = findLevel(root.left, p, level + 1);
        if (lev == -1) {
            return findLevel(root.right, p, level + 1);
        }
        return lev;
    }

    public TreeNode findLCA(TreeNode root, int p, int q) {
        if (root == null) return null;
        if (root.val == p || root.val == q) return root;
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);
        if (left != null && right != null) return root;
        return left == null ? right : left;
    }


    public static void main(String[] args) {
//        new LC_1740().findDistance()
    }
}
