package Skill.PreFixSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC_2615 {

//    2615. 等值距离和
    public long[] distance(int[] nums) {
        var mp = new HashMap<Integer, List<Integer>>();
        // 按照下标进行分组
        for (int i = 0; i < nums.length; i++) {
            mp.computeIfAbsent(nums[i], v -> new ArrayList<>());
            mp.get(nums[i]).add(i);
        }
        var ans = new long[nums.length];
        var s = new long[nums.length+1];
        for (var v : mp.values()) {
            int m = v.size();
            for (int i = 0; i < m; i++) {
                s[i+1] = s[i] + v.get(i);
            }
            for (int i = 0; i < m; i++) {
                int target = v.get(i);
                long left = (long) target * i - s[i];
                long right = s[m] - s[i] - (long) target * (m - i);
                s[target] = left + right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 1, 1, 2};
        System.out.println(Arrays.toString(new LC_2615().distance(a)));
    }
}
