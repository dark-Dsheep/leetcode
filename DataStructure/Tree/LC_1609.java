package DataStructure.Tree;


import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC_1609 {

    /*
        1609. 奇偶树
     */
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        // 偶数层 节点奇数 单增
        // 奇数层 节点偶数 单减
        while (!queue.isEmpty()) {
            int n = queue.size();
            boolean f1 = false; // true -> 奇数层 / 偶数层
            boolean f2 = false; // true -> 递增  / 递减
            if ((level & 1) == 0) {
                f1 = true;
                f2 = true;
            }
            int p1 = Integer.MAX_VALUE, p2 = Integer.MIN_VALUE;
            if (f1 && f2) {         // level是偶数
                for (int i = 0; i < n; i++) {
                    TreeNode p = queue.poll();
                    if (p2 >= p.val || ((p.val & 1) == 0)) return false;
                    p2 = p.val;
                    if (p.left != null) queue.offer(p.left);
                    if (p.right != null) queue.offer(p.right);
                }
            } else {                // level是奇数
                for (int i = 0; i < n; i++) {
                    TreeNode p = queue.poll();
                    if (p1 <= p.val || ((p.val & 1) == 1)) return false;
                    p1 = p.val;
                    if (p.left != null) queue.offer(p.left);
                    if (p.right != null) queue.offer(p.right);
                }
            }
            level += 1;
        }
        return true;
    }

    public boolean isEvenOddTree1(TreeNode root) {
        boolean even = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        // 偶数层 节点奇数 单增
        // 奇数层 节点偶数 单减
        while (!queue.isEmpty()) {
            int prev = even ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode p = queue.poll();
                if (even && ((p.val & 1) == 0 || prev >= p.val)) return false;
                if (!even && ((p.val & 1) == 1 || prev <= p.val)) return false;
                prev = p.val;
                if (p.left != null) queue.offer(p.left);
                if (p.right != null) queue.offer(p.right);
            }
            even = !even;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
