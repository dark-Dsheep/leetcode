package Math;

public class LC_2507 {

    /*
        2507. 使用质因数之和替换后可以取到的最小值
     */

    public int smallestValue(int n) {
        while (true) {
            int s = n, t = 0;
            for (int i = 2; i * i <= s; i++) {
                while (s % i == 0) {
                    t += i;
                    s /= i;
                }
            }
            if (s > 1) t += s;
            if (n == t) return n;
            n = t;
        }
    }

    public static void main(String[] args) {

    }
}
