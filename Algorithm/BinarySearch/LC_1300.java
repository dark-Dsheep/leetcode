package Algorithm.BinarySearch;

import java.util.Arrays;

public class LC_1300 {

    /*
        1300. 转变数组后最接近目标值的数组和
     */
    public int findBestValue(int[] arr, int target) {
        // 二分答案
        // 确定上下界
        int l = 1;
        int r = Arrays.stream(arr).max().getAsInt();
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int sum = getSum(arr, mid);
            if (sum == target) return mid;
            if (sum > target) {
                r = mid - 1;        // mid太大了 二分左边
            } else {
                l = mid + 1;
            }
        }
        if (Math.abs(getSum(arr, r) - target) > Math.abs(getSum(arr, l) - target)) {
            return l;
        }
        // System.out.println("r " + r);
        return r;
    }

    private int getSum(int[] arr, int mid) {
        int sum = 0;
        for (int x : arr) {
            sum += Math.min(x, mid);
        }
        return sum;
    }
}
