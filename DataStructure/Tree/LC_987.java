package DataStructure.Tree;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_987 {

//    987. 二叉树的垂序遍历

    Map<Integer, List<Node>> map = new HashMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // 将y坐标相同的分组,各组按照y坐标升序排序
        // 每个组按照x排序,x相同则按照节点值升序排序
        var ans = new ArrayList<List<Integer>>();
        dfs(root, 0, 0);
        var all = new ArrayList<>(map.entrySet());
        // System.out.println(list);
        all.sort(((o1, o2) -> o1.getKey() - o2.getKey()));
        for (var e : all) {
            var nodes = e.getValue();
            nodes.sort((o1, o2) -> o1.x == o2.x ? o1.val - o2.val : o1.x - o2.x);
            var list = new ArrayList<Integer>();
            for (var n : nodes) list.add(n.val);
            // ans.add(nodes.stream().map(i -> i.val).collect(Collectors.toList()));
            ans.add(list);
        }
        return ans;
    }

    // dfs存储节点
    void dfs(TreeNode root, int x, int y) {
        if (root == null) return;
        var node = new Node(x, y, root.val);
        if (map.containsKey(y)) {
            var list = map.get(y);
            list.add(node);
            map.put(y, list);
        } else {
            var list = new ArrayList<Node>();
            list.add(node);
            map.put(y, list);
        }
        if (root.left != null) dfs(root.left, x + 1, y - 1);
        if (root.right != null) dfs(root.right, x + 1, y + 1);
    }


    class Node {
        int x;
        int y;
        int val;

        public Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public static void main(String[] args) {

        var root = new TreeNode(3);
        var node1 = new TreeNode(9);
        var node2 = new TreeNode(20);
        var node3 = new TreeNode(15);
        var node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        System.out.println(new LC_987().verticalTraversal(root));
    }
}
