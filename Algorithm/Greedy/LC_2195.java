package Algorithm.Greedy;

import java.util.Arrays;
import java.util.HashSet;

public class LC_2195 {

//    2195. 向数组中追加 K 个整数
    //TODO

    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        var set = new HashSet<Integer>();
        for (int x : nums) set.add(x);
        int max = nums[nums.length - 1];
        int limit = max + k;
        long start = 0, last = 0, sum = 0;
        long ans = 0;
        for (int i = 1; i <= limit; i++) {
            if (i > max) {
                start = i;
                break;
            }
            if (k == 0) break;
            if (set.contains(i)) continue;
            ans += i;
            k--;
        }
        if (start != 0) {
            last = start + k - 1;
            sum = k * (start + last) / 2;
        }
        return ans + sum;
    }
    public static void main(String[] args) {

    }
}
