package Competition.weekly.wr335;

import LeetCode.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class T2 {


    public long kthLargestLevelSum(TreeNode root, int k) {
        var list = new ArrayList<Long>();
        var q = new LinkedList<TreeNode>();
        q.offer(root);
        while (q.size() > 0) {
            int n = q.size();
            long sum = 0;
            for (int i = 0; i < n; i++) {
                var p = q.poll();
                sum += p.val;
                if (p.left != null) q.offer(p.left);
                if (p.right != null) q.offer(p.right);
            }
            list.add(sum);
        }
        list.sort(((o1, o2) -> Long.compare(o1, o2)));
        return list.get(list.size() - k);
    }

    public static void main(String[] args) {

    }
}
