package Competition.weekly.wr307;

import LeetCode.utils.TreeNode;

import java.util.LinkedList;

public class T3 {

    Node st = null;
    boolean[] vis = new boolean[100001];

    public int amountOfTime(TreeNode root, int start) {
        dfs(root, start);
        var q = new LinkedList<Node>();
        q.offer(st);
        vis[st.val] = true;
        int time = -1;
        while (q.size() > 0) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                var p = q.poll();
                if (p.left != null && !vis[p.left.val]) { q.offer(p.left); vis[p.left.val] = true; }
                if (p.right != null && !vis[p.right.val]) { q.offer(p.right); vis[p.right.val] = true; }
                if (p.fa != null && !vis[p.fa.val]) { q.offer(p.fa); vis[p.fa.val] = true; }
            }
            ++time;
        }
        return time;
    }

    Node dfs(TreeNode root, int start) {
        if (root == null) return null;
        var node = new Node(root.val);
        if (node.val == start) st = node;
        node.left = dfs(root.left, start);
        node.right = dfs(root.right, start);
        if (node.left != null) node.left.fa = node;
        if (node.right != null) node.right.fa = node;
        return node;
    }

    class Node {
        int val;
        Node left;
        Node right;
        Node fa;

        public Node(int val) {
            this.val = val;
        }
    }


    public static void main(String[] args) {

    }
}
