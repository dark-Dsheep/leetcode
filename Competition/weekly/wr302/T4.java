package Competition.weekly.wr302;

import java.util.Arrays;

public class T4 {

    public int minOperations(int[] nums, int[] numsDivide) {
        // 求出numsDivide的最大公因数g
        // 排序nums 枚举nums的元素 判断g能否整除x
        Arrays.sort(nums);
        int g = 0;
        for (int x : numsDivide) {
            g = gcd(g, x);
        }
        int ans = 0;
        for (int x : nums) {
            if (g % x == 0) break;
            ans++;
        }
        return ans == nums.length ? -1 : ans;
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }

    public static void main(String[] args) {

    }
}
