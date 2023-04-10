package DataStructure.Tree;



import utils.ListNode;
import utils.StructureUtil;
import utils.TreeNode;

import java.util.List;

public class LC_1367 {

//    1367. 二叉树中的链表

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        //先判断当前的节点，如果不对，再看左子树和右子树呗
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode head, TreeNode node) {
        //特判：链表走完了，返回true
        if (head == null) {
            return true;
        }
        //特判：链表没走完，树走完了，这肯定不行，返回false
        if (node == null) {
            return false;
        }
        //如果值不同，必定不是啊
        if (head.val != node.val) {
            return false;
        }
        //如果值相同，继续看，左边和右边有一个满足即可
        return dfs(head.next, node.left) || dfs(head.next, node.right);
    }


    public static void main(String[] args) {
        var root = new TreeNode(1);
        var node1 = new TreeNode(4);
        var node2 = new TreeNode(2);
        var node3 = new TreeNode(6);
        var node4 = new TreeNode(8);
        var node5 = new TreeNode(1);
        var node6 = new TreeNode(3);
        root.right = node1;
        node1.right = node2;
        node2.left = node3;
        node2.right = node4;
        node4.left = node5;
        node4.right = node6;

        ListNode head = StructureUtil.generateListNode(List.of(4, 2, 8));
        System.out.println(new LC_1367().isSubPath(head, root));
    }
}
