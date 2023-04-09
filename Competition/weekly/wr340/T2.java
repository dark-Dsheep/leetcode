package Competition.weekly.wr340;

import java.util.Arrays;
import java.util.HashMap;

public class T2 {


    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];
        HashMap<Integer, long[]> l = new HashMap<>();
        HashMap<Integer, long[]> r = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long sum = 0, cnt = 0;
            if (l.containsKey(nums[i])) {
                long[] t = l.get(nums[i]);
                sum = t[0];
                cnt = t[1];
                ans[i] += cnt * i - sum;
            }
            l.put(nums[i], new long[]{sum+i, cnt+1});
        }
        for (int i = n-1; i >= 0; i--) {
            long sum = 0, cnt = 0;
            if (r.containsKey(nums[i])) {
                long[] t = l.get(nums[i]);
                sum = t[0];
                cnt = t[1];
                ans[i] += sum - cnt * i;
            }
            r.put(nums[i], new long[]{sum+i, cnt+1});
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 1, 2};
        System.out.println(Arrays.toString(new T2().distance(nums)));
    }
}
