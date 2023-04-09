package Competition.weekly.wr340;

import java.util.Arrays;

public class T3 {

    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        long l = 0;
        long r = 1000000000;
        while (l < r) {
            long mid = l + r >> 1;
            if (check(nums, mid, p)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return (int) l;
    }

    boolean check(int[] nums, long mid, int p) {
        int cnt = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i-1] <= mid) {
                cnt++;
                i++;
            }
        }
        return cnt >= p;
    }


    public static void main(String[] args) {
        int[] nums = {4, 2, 1, 2};
        int p = 1;
        System.out.println(new T3().minimizeMax(nums, p));
    }
}
