package DataStructure.Tree;

import LeetCode.utils.TreeNode;

public class LC_1022 {

    /*
        1022. 从根到叶的二进制数之和
     */
    int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return sum;
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            sum += Integer.parseInt(sb.toString(), 2);
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

    }
}
