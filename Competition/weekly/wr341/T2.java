package Competition.weekly.wr341;


import java.util.Arrays;

public class T2 {


    public int maxDivScore(int[] nums, int[] divisors) {
        int max = 0, ans = 0;
        for (int x : divisors) {
            int cnt = 0;
            for (int i = 0; i < nums.length; i++) { if (nums[i] % x == 0) cnt++; }
            if (cnt > max) { ans = x; max = cnt;
            } else if (cnt == max) { ans = Math.min(ans, x); }
        }
        if (ans == 0) {
            return Arrays.stream(divisors).min().getAsInt();
        } else {
            return ans;
        }
    }

    public static void main(String[] args) {

    }
}
