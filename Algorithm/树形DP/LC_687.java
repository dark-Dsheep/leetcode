package Algorithm.树形DP;

import utils.TreeNode;

public class LC_687 {

//    687. 最长同值路径

    int ans = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root, 0x3f3f3f);
        return ans;
    }

    int dfs(TreeNode root, int v) {
        if (root == null) return -1;
        int lmax = dfs(root.left, root.val) + 1;
        int rmax = dfs(root.right, root.val) + 1;
        ans = Math.max(ans, lmax + rmax);
        if (root.val != v) return -1; // 值不相同的链返回-1
        return Math.max(lmax, rmax);
    }

    public static void main(String[] args) {
        var rt = new TreeNode(1);
        var nd1 = new TreeNode(4);
        var nd2 = new TreeNode(5);
        var nd3 = new TreeNode(4);
        var nd4 = new TreeNode(4);
        var nd5 = new TreeNode(5);
        rt.left = nd1;
        rt.right = nd2;
        nd1.left = nd3;
        nd1.right = nd4;
        nd2.right = nd5;
        System.out.println(new LC_687().longestUnivaluePath(rt));
    }
}
