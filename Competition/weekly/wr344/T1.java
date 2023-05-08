package Competition.weekly.wr344;

import java.util.HashSet;

public class T1 {

    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
//        var ans = new int[n];
//        for (int i = 0; i < n; i++) {
//            int k = i, j = i + 1;
//            var a = new HashSet<Integer>();
//            var b  = new HashSet<Integer>();
//            while (k >= 0) {
//                a.add(nums[k--]);
//            }
//            while (j < n) {
//                b.add(nums[j++]);
//            }
//            ans[i] = a.size() - b.size();
//        }
//        return ans;
        var suf = new int[n+1];
        var set = new HashSet<Integer>();
        for (int i = n-1; i > 0; i--) {
            set.add(nums[i]);
            suf[i] = set.size();
        }
        set.clear();
        var ans = new int[n];
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
            ans[i] = set.size() - suf[i+1];
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
