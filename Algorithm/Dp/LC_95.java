package Algorithm.Dp;


import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC_95 {


    /*
        95. 不同的二叉搜索树 II
     */

    // 类似题目 LC-241. 为运算表达式设计优先级
    public List<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int start, int end) {
        var list = new ArrayList<TreeNode>();
        if (start > end) {
            list.add(null);
            return list;
        }
        for (var i = start; i <= end; i++) {
            // 以i为跟划分左右区间 分治
            List<TreeNode> left = dfs(start, i - 1);
            List<TreeNode> right = dfs(i + 1, end);
            for (var l : left) {
                for (var r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new LC_95().generateTrees(3));
    }
}
