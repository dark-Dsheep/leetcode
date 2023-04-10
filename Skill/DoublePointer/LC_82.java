package Skill.DoublePointer;



import utils.ListNode;
import utils.StructureUtil;

import java.util.List;

public class LC_82 {
    //82. 删除排序链表中的重复元素 II

    public ListNode deleteDuplicates(ListNode head) {
        var dummy = new ListNode(-1, head);
        var cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            int val = cur.next.val;
            if (cur.next.next.val == val) {
                while (cur.next != null && cur.next.val == val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = StructureUtil.generateListNode(List.of(1, 2, 3, 3, 4, 4, 5));
        System.out.println(new LC_82().deleteDuplicates(head));
    }
}
