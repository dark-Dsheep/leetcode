package DataStructure.单调栈;

import utils.ListNode;
import utils.StructureUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC_1019 {
    int[] a = new int[10001];
    public int[] nextLargerNodes(ListNode head) {
        int n = 0, idx = 0;
        var cur = head;
        while (cur != null) { ++n; a[idx++] = cur.val; cur = cur.next; }
        var st = new LinkedList<Integer>();
        var ans = new int[n];
        for (int i = n-1; i >= 0; i--) {
            while (st.size() > 0 && st.peek() <= a[i]) { st.pop(); }
            ans[i] = st.size() > 0 ? st.peek() : 0;
            st.push(a[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode head = StructureUtil.generateListNode(List.of(2,7,4,3,5));
        System.out.println(Arrays.toString(new LC_1019().nextLargerNodes(head)));
    }
}
