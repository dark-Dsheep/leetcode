package Competition.weekly.wr338;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class T3 {


    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        var sum = new long[n+1];
        var range = new TreeMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + nums[i];
            if (!range.containsKey(nums[i])) {
                range.put(nums[i], i);
            }
        }
        range.put(Integer.MAX_VALUE, n);
        var ans = new ArrayList<Long>(queries.length);
        for (int q : queries) {
            // 二分找上界
            int pos = range.higherEntry(q).getValue();
            long acc = 0;
            if (pos < n) {
                acc += sum[n] - sum[pos] - (long) q * (n - pos);
            }
            acc += (long) q * pos - sum[pos];
            ans.add(acc);
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
