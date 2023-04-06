package DataStructure.Tree;

import LeetCode.utils.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

public class LC_1145 {

    /*
        1145. 二叉树着色游戏
     */
    private int N = 210, M = N * 4;
    private int[] he = new int[N]; // 存储某个节点对应边的集合的头节点
    private int[] e = new int[M]; // 由于访问某一条边指向的节点
    private int[] ne = new int[M]; // 以链表的形式存边,用于找到下一条边
    private int idx;

    private void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
    }

    private boolean[] vis = new boolean[N];

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        Arrays.fill(he, -1);
        dfs(root);          // 建图
        for (var i = 1; i <= n; i++) {
            if (i == x) continue;
            Arrays.fill(vis, false);
            if (bfs(x, i)) return true;
        }
        return false;
    }
    // 0-蓝色 1-红色
    private boolean bfs(int x, int y) {
        // 多源BFS
        var queue = new LinkedList<int[]>();
        queue.offer(new int[]{x, 1});
        queue.offer(new int[]{y, 0});
        vis[x] = vis[y] = true;
        var rCnt = 1;
        var bCnt = 1;
        while (!queue.isEmpty()) {
            var size = queue.size();
            while (size-- > 0) {
                var p = queue.poll();
                int u = p[0], color = p[1];
                for (var i = he[u]; i != -1; i = ne[i]) { // 向星图遍历方式
                    var next = e[i];
                    if (!vis[next]) {
                        vis[next] = true;
                        if (color == 0) bCnt++;
                        else            rCnt++;
                        queue.offer(new int[]{next, color});
                    }
                }
            }
        }
        return bCnt > rCnt;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            add(root.val, root.left.val);
            add(root.left.val, root.val);
            dfs(root.left);
        }
        if (root.right != null) {
            add(root.val, root.right.val);
            add(root.right.val, root.val);
            dfs(root.right);
        }
    }

    public static void main(String[] args) {
        var root = new TreeNode(1);
        var node1 = new TreeNode(2);
        var node2 = new TreeNode(3);
        var node3 = new TreeNode(4);
        var node4 = new TreeNode(5);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;


        System.out.println(new LC_1145().btreeGameWinningMove(root, 5, 4));

    }

    // 解法二
    public boolean btreeGameWinningMove2(TreeNode root, int n, int x) {
        // 贪心思路: 玩家2在节点x的三个邻节点中选择子树最多的着色
        TreeNode X = findX(root, x);
        int cntLeft = cntNodes(X.left);
        int cntRight = cntNodes(X.right);
        // 计算玩家2的最多染色个数
        int maxCnt = Math.max(n - cntLeft - cntRight - 1, Math.max(cntLeft, cntRight));
        // return maxCnt > n - maxCnt;
        return 2 * maxCnt > n;
    }

    private int cntNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + cntNodes(root.left) + cntNodes(root.right);
    }

    private TreeNode findX(TreeNode root, int x) {
        if (root == null) return null;
        if (root.val == x) return root;
        TreeNode l = findX(root.left, x);
        if (l != null) return l;
        TreeNode r = findX(root.right, x);
        if (r != null) return r;
        return null;
    }
}
