package DataStructure.Tree;

import LeetCode.utils.TreeNode;

public class LC_1399 {

    long sum = 0;
    long ans = 0;
    int mod = (int) 1e9 + 7;

    //    1339. 分裂二叉树的最大乘积

    public int maxProduct(TreeNode root) {
        calSum(root);
        // System.out.println("sum -> " + sum);
        change(root);
        dfs(root);
        return (int) (ans % mod);
    }

    void dfs(TreeNode root) {
        if (root == null) return;
        if (root.left != null) dfs(root.left);
        if (root.right != null) dfs(root.right);
        long subSum = root.val;
        // 枚举分割每个节点,求最大值
        ans = Math.max(ans, subSum * (sum - subSum));
    }

    // 将每个节点的值改为 以该节点为根的子树之和
    long change(TreeNode root) {
        if (root == null) return 0;
        long subSum = root.val;
        subSum += change(root.left);
        subSum += change(root.right);
        root.val = (int) subSum;
        return subSum;
    }
    // 计算树的总和
    void calSum(TreeNode root) {
        if (root == null) return;
        sum += root.val;
        if (root.left != null) calSum(root.left);
        if (root.right != null) calSum(root.right);
    }

    public static void main(String[] args) {

    }
}
