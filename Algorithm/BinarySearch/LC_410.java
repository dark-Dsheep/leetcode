package Algorithm.BinarySearch;

import java.util.Arrays;

public class LC_410 {

    /*
        410. 分割数组的最大值
     */
    public int splitArray(int[] nums, int k) {
        // 最大值最小 -> 模板1
        // 定义上下界
        int l = Arrays.stream(nums).max().getAsInt();
        int r = Arrays.stream(nums).sum();

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(nums, mid, k)) {
                l = mid + 1;
            } else {
                r = mid;            // mid太大了 二分左边
            }
        }
        return l;
    }

    private boolean check(int[] nums, int mid, int k) {
        // 7 2 5 10 8
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > mid) {
                sum = 0;
                k--;         // 划分1个
            }
            sum += nums[i];
        }
        return k <= 0; // 刚好分完或者多划分了几个都应该增大mid
    }

    public static void main(String[] args) {
        System.out.println(5 / 3);
    }
}
