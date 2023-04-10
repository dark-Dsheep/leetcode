package DataStructure.LinkedList;


import utils.ListNode;

public class LC_25 {


//    25. K 个一组翻转链表

    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        var cur = head;
        while (cur != null) { cur = cur.next; len++; }
        var dummy = new ListNode(0, head);
        var p0 = dummy;
        while (len >= k) {
            len -= k;
            cur = p0.next;
            ListNode pre = null, next = null;
            // 反转 k个一组
            for (int i = 0; i < k; i++) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            var nxt = p0.next; // 保存p0下一组的位置
            // 连接答案
            p0.next.next = cur;
            p0.next = pre;
            p0 = nxt;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
