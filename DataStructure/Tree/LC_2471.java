package DataStructure.Tree;



import utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LC_2471 {

//    2471. 逐层排序二叉树所需的最少操作数目

    public int minimumOperations(TreeNode root) {
        int res = 0;
        var q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            int n = q.size();
            var list = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                var p = q.poll();
                list.add(p.val);
                if (p.left != null) q.offer(p.left);
                if (p.right != null) q.offer(p.right);
            }
            if (list.size() != 1) {
                res += getMinSwaps(list);
            }
        }
        return res;
    }
    // 计算排序list的最少交换次数
    private int getMinSwaps(List<Integer> list) {
        var list1 = new ArrayList<>(list);
        list1.sort(((o1, o2) -> o1 - o2));
        int n = list.size();
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            map.put(list1.get(i), i);
        }
        int r = 0;
        var vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                int j = i;
                while (!vis[j]) {
                    vis[j] = true;
                    j = map.get(list.get(j));
                }
                r++;
            }
        }
        // System.out.println("r=" + r);
        return n - r;
    }
}
