package DataStructure.Tree;

import LeetCode.utils.TreeNode;

public class LC_1315 {


    /*
            1315. 祖父节点值为偶数的节点和
     */

    int sum;

    public int sumEvenGrandparent(TreeNode root) {
        dfs(root);
        return sum;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        if ((root.val & 1) == 0) {
            if (root.left != null) {
                if (root.left.left != null) {
                    sum += root.left.left.val;
                }
                if (root.left.right != null) {
                    sum += root.left.right.val;
                }
            }
            if (root.right != null) {
                if (root.right.left != null) {
                    sum += root.right.left.val;
                }
                if (root.right.right != null) {
                    sum += root.right.right.val;
                }
            }
        }
        dfs(root.left);
        dfs(root.right);

    }

    public static void main(String[] args) {

    }
}
