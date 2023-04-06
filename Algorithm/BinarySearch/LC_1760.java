package Algorithm.BinarySearch;

import java.util.Arrays;

public class LC_1760 {

    /*
        1760. 袋子里最少数目的球
     */

    public int minimumSize(int[] nums, int maxOperations) {
        // 二分答案
        // 定义上下界
        long l = 1;
        long r = Arrays.stream(nums).max().getAsInt();

        while (l < r) {
            long mid = l + (r - l) / 2;
            if (check(nums, mid, maxOperations)) {
                r = mid;           // 能够划分 -> mid再取小点
            } else {
                l = mid + 1;
            }
        }
        return (int) l;
    }

    // nums经过k次操作后, 开销是否 >= mid
    private boolean check(int[] nums, long mid, int k) {
        long cnt = 0;
        for (int x : nums) {
            // 计算当前袋子能分几次
            cnt += (x - 1) / mid;
        }
        return cnt <= k;
    }

    public static void main(String[] args) {

        int[] nums = {9};
        int maxOpts = 2;
        System.out.println(new LC_1760().minimumSize(nums, maxOpts));
    }
}
