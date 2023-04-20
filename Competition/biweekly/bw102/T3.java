package Competition.biweekly.bw102;



import utils.TreeNode;

import java.util.LinkedList;


public class T3 {

    public TreeNode replaceValueInTree(TreeNode root) {
        root.val = 0;
        var q = new LinkedList<TreeNode>();
        q.offer(root);
        while (q.size() > 0) {
            var tmp = q;
            q = new LinkedList<>();
            int nextLevelSum = 0; // 下一层节点值之和
            for (var node : tmp) {
                if (node.left != null) {
                    q.offer(node.left);
                    nextLevelSum += node.left.val;
                }
                if (node.right != null) {
                    q.offer(node.right);
                    nextLevelSum += node.right.val;
                }
            }
            // 更新下一层节点值
            for (var node : tmp) {
                int chSum = (node.left != null ? node.left.val : 0) + (node.right != null ? node.right.val : 0);
                if (node.left != null) node.left.val = nextLevelSum - chSum;
                if (node.right != null) node.right.val = nextLevelSum - chSum;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        var root = new TreeNode(5);
        var node1 = new TreeNode(4);
        var node2 = new TreeNode(9);
        var node3 = new TreeNode(1);
        var node4 = new TreeNode(10);
        var node5 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        System.out.println(new T3().replaceValueInTree(root));
    }
}
