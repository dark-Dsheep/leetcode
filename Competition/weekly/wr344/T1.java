package Competition.weekly.wr344;

import java.util.HashSet;

public class T1 {

    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        var ans = new int[n];
        for (int i = 0; i < n; i++) {
            int k = i, j = i + 1;
            var a = new HashSet<Integer>();
            var b  = new HashSet<Integer>();
            while (k >= 0) {
                a.add(nums[k--]);
            }
            while (j < n) {
                b.add(nums[j++]);
            }
            ans[i] = a.size() - b.size();
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
