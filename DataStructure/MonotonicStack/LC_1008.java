package DataStructure.MonotonicStack;

import LeetCode.utils.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

public class LC_1008 {


    /*
        1008. 前序遍历构造二叉搜索树
        TODO
     */
    int n;
    boolean[] vis = new boolean[110];

    public TreeNode bstFromPreorder(int[] p) {
        // 创建单调递增 递减栈
        var incrStack = new LinkedList<Integer>();
        var decrStack = new LinkedList<Integer>();
        n = p.length;
        int[] a = new int[n], b = new int[n];

        for (var i = n - 1; i >= 0; i--) {
            while (!incrStack.isEmpty() && p[incrStack.peek()] < p[i]) {
                incrStack.pop();
            }
            while (!decrStack.isEmpty() && p[decrStack.peek()] > p[i]) {
                decrStack.pop();
            }
            a[i] = incrStack.isEmpty() ? -1 : incrStack.peek();
            b[i] = decrStack.isEmpty() ? -1 : decrStack.peek();
            incrStack.push(i);
            decrStack.push(i);
        }
        TreeNode root = new TreeNode(p[0]);

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        return null;
    }


    public static void main(String[] args) {
        var p = new int[]{8, 5, 1, 7, 10, 12};
        System.out.println(new LC_1008().bstFromPreorder(p));
    }
}
