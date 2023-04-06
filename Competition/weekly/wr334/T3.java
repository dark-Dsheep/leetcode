package Competition.weekly.wr334;

import java.util.Arrays;

public class T3 {

    // 二分答案
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = nums.length / 2;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(nums, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return 2 * l;
    }
    // check是否满足k段
    boolean check(int[] nums, int k) {
        int i = 0, j = nums.length - k;
        while (j < nums.length) {
            if (2 * nums[i] > nums[j]) return false;
            i++; j++;
        }
        return true;
    }

    // 排序 + 双指针贪心
    public int maxNumOfMarkedIndices2(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = (nums.length + 1) / 2;
        int ans = 0;
        while (j < nums.length) {
            if (2 * nums[i] <= nums[j]) {
                ans += 2;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
