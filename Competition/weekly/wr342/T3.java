package Competition.weekly.wr342;

import java.util.*;

public class T3 {

    int[] count = new int[110];

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        var ans = new int[nums.length-k+1];
        int offset = 50; // [-50, 50]
        for (int i = 0, idx = 0; i < nums.length; i++) {
            count[nums[i] + offset]++;
            if (i >= k - 1) {
                int v = x;
                for (int j = 0; j <= 50; j++) {
                    if (count[j] == 0) continue;
                    if (count[j] >= v) { ans[idx] = j - offset; break; }
                    else { v -= count[j]; }
                }
                count[nums[idx] + offset]--;
                idx++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1, -1, -3, -2, 3};
        int k = 3;
        int x = 2;
        System.out.println(Arrays.toString(new T3().getSubarrayBeauty(a, k, x)));
    }
}
