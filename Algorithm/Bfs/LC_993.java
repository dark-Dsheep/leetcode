package Algorithm.Bfs;



import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC_993 {

    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // x,y在同一层， 不同父节点, 即可满足条件
        while (!queue.isEmpty()) {
            int n = queue.size();
            int cnt = 0; // 记录一层中x，y出现次数
            for (int i = 0; i < n; i++) {
                TreeNode p = queue.poll();
                if (p.val == x || p.val == y) cnt++;
                if (p.left != null && p.right != null) {
                    // x, y在同一个父节点p下面 -> 不满足条件
                    if ((p.left.val == x && p.right.val == y) || (p.left.val == y && p.right.val == x)) {
                        return false;
                    }
                    queue.offer(p.left);
                    queue.offer(p.right);
                    continue;
                }
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
            }
            if (cnt == 2) return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
