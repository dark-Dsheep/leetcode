package Competition.weekly.wr308;

import java.util.Arrays;

public class T1 {

    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length, idx = 0;
        var ans = new int[queries.length];
        for (int x : queries) {
            int sum = 0;
            ans[idx] = n;
            for (int i = 0; i < n; i++) {
                sum += nums[i];
                if (sum > x) {
                    ans[idx] = i;
                    break;
                }
            }
            idx++;
        }
        return ans;
    }
}
