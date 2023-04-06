package Math;

public class LC_50 {
    /*
        50. Pow(x, n)
     */

    // 快速幂模板
    public double myPow(double x, int n) {
        double res = 1;
        long b = n;
        if (b < 0) {
            b = -b;
            x =  1 / x;
        }
        while (b > 0) {
            if ((b & 1) == 1) res = res * x;
            b = b >> 1;
            x = x * x;
        }
        return res;
    }

    static int qpow(int a, int b, int p) {
        int res = 1 % p;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % p;
            b >>= 1;
            a = (a * a) % p;
        }
        return res % p;
    }

    public static void main(String[] args) {
//        System.out.println(new LC_50().myPow(2.00000, 10));

        System.out.println(qpow(2, 55, 100000009));
    }
}
