package DataStructure.Array;

import java.util.Arrays;

public class LC_1508 {

    /*
        1508. 子数组和排序后的区间和
     */

    int mod = (int) 1e9 + 7;
    // TODO 暴力模拟
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] arr = new int[n * (n + 1) / 2];
        int k = 0;
        for (int i = 0; i < n; i++) {
            arr[k] = nums[i];
            k++;
            for (int j = i + 1; j < n; j++) {
                arr[k] = arr[k - 1] + nums[j];
                k++;
            }
        }
        Arrays.sort(arr);
        long sum = 0;
        for (int i = left - 1; i < right; i++) {
            sum += (arr[i] % mod);
        }
        return (int) (sum % mod);
    }



    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int n = 4;
        int left = 1;
        int right = 5;
        System.out.println(new LC_1508().rangeSum(nums, n, left, right));
    }
}
