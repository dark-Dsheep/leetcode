package Algorithm.BinarySearch;

import LeetCode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC_2476 {

    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        // 中序 + 二分

        dfs(root);
        List<List<Integer>> res = new ArrayList<>();
        for (int q : queries) {
            List<Integer> ans = new ArrayList<>();
            ans.add(findMax(q));
            ans.add(findMin(q));
            res.add(ans);
        }
        return res;
    }

    int findMax(int target) { // 小于等于t的最大值
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (list.get(mid) > target) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return list.get(l) <= target ? list.get(l) : -1;
    }

    int findMin(int target) { // 大于等于t的最小值
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (list.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return list.get(l) >= target ? list.get(l) : -1;
    }

    void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }


    public static void main(String[] args) {

    }
}
