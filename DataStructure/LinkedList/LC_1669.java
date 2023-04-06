package DataStructure.LinkedList;

import LeetCode.utils.ListNode;

import java.util.List;

import static LeetCode.utils.StructureUtil.generateListNode;

public class LC_1669 {

    /*
        1669. 合并两个链表
     */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode cur = list1;
        ListNode pre = null;
        int index = 0;
        while (index != a) {
            pre = cur;
            cur = cur.next;
            index++;
        }
        pre.next = list2;    // 连接list2
        ListNode cur2 = list2;
        while (index != b) {
            cur = cur.next;
            index++;
        }
        while (cur2.next != null) {
            cur2 = cur2.next;
        }
        cur2.next = cur.next;
        return list1;
    }

    public static void main(String[] args) {
        ListNode list1 = generateListNode(List.of(0, 1, 2, 3, 4, 5));
        ListNode list2 = generateListNode(List.of(1000000, 1000001, 1000002));
        System.out.println(new LC_1669().mergeInBetween(list1, 3, 4, list2));
    }
}
