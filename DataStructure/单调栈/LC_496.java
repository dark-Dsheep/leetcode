package DataStructure.单调栈;

import java.util.HashMap;
import java.util.LinkedList;

public class LC_496 {

    /*
        496. 下一个更大元素 I
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 求nums2中元素的单调性
        LinkedList<Integer> stack = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }

    public static void main(String[] args) {

    }
}
