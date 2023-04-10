package DataStructure.Tree;



import utils.TreeNode;

import java.util.LinkedList;

public class LC_958 {


//    958. 二叉树的完全性检验

    public boolean isCompleteTree(TreeNode root) {
        var q = new LinkedList<TreeNode>();
        q.offer(root);
        var ok = false;
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                var p = q.poll();
                if (p == null) {
                    ok = true;          // 标记出现了空节点
                    continue;
                }
                System.out.println(p);
                if (ok) return false;   // 前面存在空节点
                q.offer(p.left);
                q.offer(p.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
