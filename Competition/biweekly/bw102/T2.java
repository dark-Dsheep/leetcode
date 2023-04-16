package Competition.biweekly.bw102;

import java.util.Arrays;

public class T2 {


    public long[] findPrefixScore(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];
        ans[0] = 2L * nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
            ans[i] = ans[i-1] + max + nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {2,3,7,5,10};
        System.out.println(Arrays.toString(new T2().findPrefixScore(a)));
    }
}
