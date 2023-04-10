package utils;

import java.util.List;

/**
 * 数据结构工具
 */
public class StructureUtil {

    public static ListNode generateListNode(List<Integer> list) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int x : list) {
            cur.next = new ListNode(x);
            cur = cur.next;
        }
        return dummy.next;
    }

}
