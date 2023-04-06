package DataStructure.Tree;

import LeetCode.utils.TreeNode;

public class LC_988 {

    /*
        988. 从叶结点开始的最小字符串
     */
    String res = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return res;
    }

    public void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append((char) ('a' + root.val));
        if (root.left == null && root.right == null) {
            StringBuilder path = new StringBuilder(sb);
            String s =  path.reverse().toString();
            if (res.compareTo(s) > 0) {
                res = s;
            }
            return;
        }
        if (root.left != null) {
            dfs(root.left, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (root.right != null) {
            dfs(root.right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(25);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(2);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        System.out.println(new LC_988().smallestFromLeaf(root));
    }
}
