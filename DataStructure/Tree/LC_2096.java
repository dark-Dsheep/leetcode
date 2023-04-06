package DataStructure.Tree;

import LeetCode.utils.TreeNode;

public class LC_2096 {

    String p1 = "", p2 = "";
//    2096. 从二叉树一个节点到另一个节点每一步的方向


    public String getDirections(TreeNode root, int startValue, int destValue) {
        // 1.找到两个节点的最近公共祖先LCA
        var lca = getLCA(root, startValue, destValue);
        // System.out.println("LCA => " + lca.val);
        // 2.计算start到LCA的U个数,计算LCA到dest的L或者R个数
        getPart1(lca, startValue, new StringBuilder());
        getPart2(lca, destValue, new StringBuilder());
        // 3.拼接两条路径
        // System.out.println("p1 => " + p1 + " p2 => " + p2);
        return p1 + p2;
    }

    void getPart1(TreeNode root, int target, StringBuilder path) {
        if (root == null) return;
        if (root.val == target) {
            p1 = path.toString();
            return;
        }
        getPart1(root.left, target, path.append("U"));
        path.deleteCharAt(path.length() - 1);
        getPart1(root.right, target, path.append("U"));
        path.deleteCharAt(path.length() - 1);
    }

    void getPart2(TreeNode root, int target, StringBuilder path) {
        if (root == null) return;
        if (root.val == target) {
            p2 = path.toString();
            return;
        }
        getPart2(root.left, target, path.append("L"));
        path.deleteCharAt(path.length() - 1);
        getPart2(root.right, target, path.append("R"));
        path.deleteCharAt(path.length() - 1);
    }

    TreeNode getLCA(TreeNode root, int p, int q) {
        if (root == null) return null;
        if (root.val == p || root.val == q) return root;
        var l = getLCA(root.left, p, q);
        var r = getLCA(root.right, p, q);
        if (l != null && r != null) return root;
        return l == null ? r : l;
    }

    public static void main(String[] args) {

    }
}
