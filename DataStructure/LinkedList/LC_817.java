package DataStructure.LinkedList;


import utils.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_817 {

    /*
        817. 链表组件
        TODO
     */
    public int numComponents(ListNode head, int[] nums) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        Arrays.sort(nums);
        int cnt = 0;
        // 0 1 2
        // 0 2
        int i = 0, j = 0;
        while (i < list.size() && j < nums.length) {
            if (list.get(i) == nums[j]) {
                // 尝试扩展链表组件

            } else {
                cnt++;
            }
        }
        return cnt;
    }


    public static void main(String[] args) {

    }
}
