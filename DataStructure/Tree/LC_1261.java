package DataStructure.Tree;



import utils.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class LC_1261 {

    /*
        1261. 在受污染的二叉树中查找元素
     */
    class FindElements {

        private Set<Integer> set;

        public FindElements(TreeNode root) {
            this.set = new HashSet<>();
            root.val = 0;
            recover(root);
        }

        public boolean find(int target) {
            return set.contains(target);
        }
        // recover整棵树
        private void recover(TreeNode root) {
            if (root == null) return;
            set.add(root.val);
            if (root.left != null) {
                root.left.val = (root.val << 1) + 1;
                recover(root.left);
            }
            if (root.right != null) {
                root.right.val = (root.val << 1) + 2;
                recover(root.right);
            }
        }
    }

    public static void main(String[] args) {

    }
}
