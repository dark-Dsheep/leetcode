package DataStructure.LinkedList;


import utils.ListNode;

public class LC_92 {

//    92. 反转链表 II
    public ListNode reverseBetween(ListNode head, int left, int right) {
        var dummy = new ListNode(0);
        dummy.next = head;
        var p0 = dummy; // 指向left位置的前一个节点
        for (int i = 1; i < left; i++) p0 = p0.next;
        ListNode pre = null;
        ListNode cur = p0.next;
        ListNode next = null;
        // 反转 cur -> right区间的节点
        int n = right - left + 1;
        for (int i = 0; i < n; i++) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 连接答案
        p0.next.next = cur;
        p0.next = pre;
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
