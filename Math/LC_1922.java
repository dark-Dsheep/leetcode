package Math;

public class LC_1922 {

    public int countGoodNumbers(long n) {
        int mod = (int) 1e9 + 7;
        // n:   1 2 3   4   ...
        // ans: 5 20 100 400 ...
        // 5 = 5^1 * 4^0
        // 20 = 5^1 * 4^1
        // 100 = 5^2 * 4^1
        // 400 = 5^2 * 4^2
        // 观察可得规律:
        // 当n是奇数 ans = 5^(n % 2 + n / 2) * 4^(n % 2 + n / 2 - 1)
        // 当n是偶数 ans = 5^(n % 2 + n / 2)) * 4^(n % 2 + n / 2))
        long b1 = n % 2 + n / 2;
        long b2 = 0;

        if (n % 2 == 0) b2 = b1;
        else            b2 = b1 - 1;

        return (int) (qpow(5, b1, mod) * qpow(4, b2, mod) % mod);
    }

    // n很大,使用快速幂
    long qpow(long a, long b, int m) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans *= a;
                ans %= m;
            }
            a *= a;
            a %= m;
            b >>= 1;
        }
        // System.out.println("ans =>" + ans);
        return ans;
    }

    public static void main(String[] args) {
        long n = 50;
        System.out.println(new LC_1922().countGoodNumbers(n));
    }
}
