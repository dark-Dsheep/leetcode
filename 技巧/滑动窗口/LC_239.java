package 技巧.滑动窗口;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.TreeMap;

public class LC_239 {

    /*
        LC239. 滑动窗口的最大值

     */

    public int[] maxSlidingWindow2(int[] nums, int k) {
        // 单调队列
        // 队首是窗口最大元素下标
        // 从队尾添加元素
        Deque<Integer> queue = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // 不停的删除比新元素小的队尾元素
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            if (i >= k - 1) { // 窗口大小刚好为k
                while (!queue.isEmpty() && queue.peekFirst() < i - k + 1) { // 检查队首元素是否在窗口区间
                    queue.pollFirst(); // 不合法的窗口下标
                }
                res[i - k + 1] = nums[queue.peekFirst()];
            }
        }
        return res;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        // 有序集合
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        int l = 0, r = 0, n = nums.length;
        int[] res = new int[n - k + 1];
        int i = 0;
        while (r < n) {
            tmap.put(nums[r], tmap.getOrDefault(nums[r], 0) + 1);
            if (r - l + 1 >= k) {
                res[i++] = tmap.lastKey();
                tmap.put(nums[l], tmap.get(nums[l]) - 1);
                if (tmap.get(nums[l]) == 0) tmap.remove(nums[l]);
                l++;
            }
            r++;
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(new LC_239().maxSlidingWindow(nums, k)));
    }
}
