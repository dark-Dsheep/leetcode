package DataStructure.Array;



import utils.ListNode;

import java.util.Arrays;

public class LC_2326 {

    /*
        2326. 螺旋矩阵 IV
     */

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        // 类似题目LC-54螺旋矩阵
        var res = new int[m][n];
        for (var r : res) Arrays.fill(r, -1);
        ListNode cur = head;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        while (cur != null) {
            // 右
            for (var i = left; i <= right && cur != null; i++) {
                res[top][i] = cur.val;
                cur = cur.next;
            }
            if (++top > bottom) break;      // top往bottom靠拢
            // 下
            for (var i = top; i <= bottom && cur != null; i++) {
                res[i][right] = cur.val;
                cur = cur.next;
            }
            if (--right < left) break;      // right往left靠拢
            // 左
            for (var i = right; i >= left && cur != null; i--) {
                res[bottom][i] = cur.val;
                cur = cur.next;
            }
            if (--bottom < top) break;      // bottom往top靠拢
            // 上
            for (var i = bottom; i >= top && cur != null; i--) {
                res[i][left] = cur.val;
                cur = cur.next;
            }
            if (++left > right) break;      // left往right靠拢
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
