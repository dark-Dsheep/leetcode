package DataStructure.Tree;

import LeetCode.utils.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

public class LC_2196 {

//    2196. 根据描述创建二叉树

    public TreeNode createBinaryTree(int[][] descriptions) {
        var set = new HashSet<Integer>();           // 记录子节点
        var map = new HashMap<Integer, TreeNode>(); // 保存数值 与节点的映射关系
        for (var d : descriptions) {
            int p = d[0], c = d[1], left = d[2];
            if (!map.containsKey(p)) map.put(p, new TreeNode(p));
            if (!map.containsKey(c)) map.put(c, new TreeNode(c));
            if (left == 1) map.get(p).left = map.get(c);
            else           map.get(p).right = map.get(c);
            set.add(c);
        }
        for (var d : descriptions) {
            if (!set.contains(d[0])) { // 如果子节点不存在 d[0] 则说d[0]是root
                return map.get(d[0]);
            }
        }
        return null;
    }
    public static void main(String[] args) {
        int[][] desc = {{20, 15, 1}, {20,  17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1}};
        System.out.println(new LC_2196().createBinaryTree(desc));
    }
}
