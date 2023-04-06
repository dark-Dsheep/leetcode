package DataStructure.MonotonicStack;

import java.util.ArrayDeque;

public class LC_962 {


    /*
        962. 最大宽度坡
     */
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int res = 0;
        // 暴力优化
//        for (int i = 0; i < n; i++) {
//            for (int j = n - 1; j > i; j--) {
//                if (nums[i] <= nums[j]) {
//                    // 因为j是从后往前遍历,坡宽只会越来越小
//                    // 当小于最优的res时就可以停止遍历
//                    if (j - i < res) break;
//                    res = Math.max(res, j - i);
//                }
//            }
//        }
        // TreeMap
//        var tmap = new TreeMap<Integer, Integer>();
//        tmap.put(-1, n);
//        for (int i = 0; i < n; i++) {
//            int a = tmap.floorKey(nums[i]);
//            res = Math.max(res, i - tmap.get(a));
//            if (!tmap.containsKey(nums[i])) tmap.put(nums[i], i);
//            // 更新小于nums[i]的最下标
//            tmap.put(nums[i], Math.min(tmap.get(nums[i]), tmap.get(a)));
//        }
        // 单调栈
        var stack = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            while (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }
        for (int j = n - 1; j >= 0; j--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
                int i = stack.pop();
                res = Math.max(res, j - i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        var nums = new int[] {6, 0, 8, 2, 1, 5};
        System.out.println(new LC_962().maxWidthRamp(nums));
    }
}
