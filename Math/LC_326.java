package Math;

public class LC_326 {

    /*
        326. 3 的幂
     */
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    // 解法二
    public boolean isPowerOfThree2(int n) {
        // int范围内3的幂最大为 -> 3^1 = 1162261467。
        // 如果 n 为 3 的幂的话，那么必然满足 n * 3^k = 1162261467 -> 3^1 * 3^18 = 1162261467
        return n > 0 && 1162261467 % n == 0;
    }

    public static void main(String[] args) {
        System.out.println(new LC_326().isPowerOfThree(45));
    }
}
