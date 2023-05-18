package Competition.周赛补题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_2602 {

    //2602. 使数组元素全部相等的最少操作次数

    public List<Long> minOperations(int[] nums, int[] queries) {
        int n = nums.length;
        Arrays.sort(nums);
        var sum = new long[n+1];
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
        var ans = new ArrayList<Long>();
        for (int q : queries) {
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (nums[mid] > q) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (nums[l] > q) {
                long left = (long) l * q - sum[l];                 // 左边
                long right = sum[n] - sum[l] - (long) (n - l) * q; // 右边
                ans.add(left + right);
            } else {
                ans.add((long) n * q - sum[n]); // 只有右边
            }
        }
        return ans;
    }



    public static void main(String[] args) {

    }
}
