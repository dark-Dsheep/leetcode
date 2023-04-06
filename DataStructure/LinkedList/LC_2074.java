package DataStructure.LinkedList;

import LeetCode.utils.ListNode;
import LeetCode.utils.StructureUtil;

import java.util.ArrayList;
import java.util.List;

public class LC_2074 {

//    2074. 反转偶数长度组的节点

    public ListNode reverseEvenLengthGroups(ListNode head) {
        if (head.next == null || head.next.next == null) {
            return head;
        }
        var list = new ArrayList<Integer>();
        var cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int n = list.size(), idx = 0, cnt = 0;
        while (idx < n) {
            int end = Math.min(idx + cnt, n);
            if ((end - idx) % 2 == 0) {
                reverse(list, idx, end - 1);
            }
            idx = end;
            cnt++;
        }
        cur = head;
        for (int x : list) {
            cur.val = x;
            cur = cur.next;
        }
        return head;
    }

    void reverse(List<Integer> list, int l, int r) {
        int temp = 0;
        while (l < r) {
            temp = list.get(r);
            list.set(r, list.get(l));
            list.set(l, temp);
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        ListNode head = StructureUtil.generateListNode(List.of(5, 2, 6, 3, 9, 1, 7, 3, 8, 4));
        System.out.println(new LC_2074().reverseEvenLengthGroups(head));
    }
}
