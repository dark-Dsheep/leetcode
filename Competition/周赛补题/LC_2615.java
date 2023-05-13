package Competition.周赛补题;

import java.util.*;

public class LC_2615 {

    // LC_WEEKLY340 Q2 2615. 等值距离和

    public long[] distance(int[] nums) {
        int n = nums.length;
        var map = new HashMap<Integer, List<Integer>>(); // 对nums[i]进行一个分组
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], v -> new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        var ans = new long[n];
        for (var list : map.values()) {
            int sz = list.size();
            var sum = new long[sz+1]; // 等值下标距离前缀和
            for (int k = 0; k < sz; k++) {
                sum[k+1] = sum[k] + list.get(k);
            }
            for (int i = 0; i < sz; i++) {
                int idx = list.get(i);
                long left = (long) i * idx - sum[i]; // 左边与idx等值的距离和
                long right = sum[sz] - sum[i] - (long) (sz - i) * idx; // 右边与idx等值的距离和
                ans[idx] = left + right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 1, 2};
        System.out.println(Arrays.toString(new LC_2615().distance(nums)));
    }
}
