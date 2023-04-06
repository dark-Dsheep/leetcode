package Competition.biweekly.bw97;

import java.util.Arrays;
import java.util.HashMap;

public class T3 {


    public int maximizeWin(int[] prize, int k) {
        int n = prize.length;
        long[] nums = new long[n + 1];
        for (var i = 1; i <= n; i++) {
            nums[i] = prize[i - 1];
        }
        HashMap<Long, Integer> count = new HashMap<>();
        for (var i = 0; i < nums.length; i++) {
            if (i == 0) continue;
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(count);
        return -1;
    }

    public static void main(String[] args) {
        int[] p = {1,1,2,2,3,3,5};
        int k = 2;
        System.out.println(new T3().maximizeWin(p, k));
    }
}
