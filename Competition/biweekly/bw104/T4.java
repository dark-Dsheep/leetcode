package Competition.biweekly.bw104;

import java.util.Arrays;

public class T4 {

    static final long MOD = 1000000007;

    public int sumOfPower(int[] nums) {
        Arrays.sort(nums);
        // 枚举x = nums[i]作为最大值
        // x一个数的力量 => x^3 -> mx^2 * mn^1
        // a b c 枚举到c时, a作为最小值, b, c可选可不选 -> 一共2^2种方案 => a的贡献为 a * 2^2
        long ans = 0, left = 0; // left 记作左侧元素对答案的贡献
        for (long x : nums) {
            ans = (ans + x * x % MOD * (x + left)) % MOD;
            left = (left * 2 + x) % MOD;
        }
        return (int) ans;
    }



    public static void main(String[] args) {
    }
}
