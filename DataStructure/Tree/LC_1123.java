package DataStructure.Tree;


import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class LC_1123 {

    /*
        1123. 最深叶节点的最近公共祖先
     */
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int depth = dfs(root);
        // 最后一层的节点是 最深的叶子节点
        var q = new LinkedList<TreeNode>();
        q.offer(root);
        var list = new ArrayList<TreeNode>();
        int level = 1;
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                var p = q.poll();
                if (level == depth) list.add(p);
                if (p.left != null) q.offer(p.left);
                if (p.right != null) q.offer(p.right);
            }
            level++;
        }
        var a = list.get(0);
        var b = list.get(list.size() - 1);
        return LCA(root, a, b);
    }

    // 返回二叉树最大深度
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        return Math.max(dfs(root.left), dfs(root.right)) + 1;
    }

    // 返回最近公共祖先
    private TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        var l = LCA(root.left, p, q);
        var r = LCA(root.right, p, q);
        if (l != null && r != null) return root;
        return l == null ? r : l;
    }


    public static void main(String[] args) {
        var root = new TreeNode(3);
        var node1 = new TreeNode(5);
        var node2 = new TreeNode(1);
        var node3 = new TreeNode(6);
        var node4 = new TreeNode(2);
        var node5 = new TreeNode(0);
        var node6 = new TreeNode(8);
        var node7 = new TreeNode(7);
        var node8 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node4.left = node7;
        node4.right = node8;

        System.out.println(new LC_1123().lcaDeepestLeaves(root));
    }
}
