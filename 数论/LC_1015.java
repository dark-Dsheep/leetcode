package 数论;

public class LC_1015 {

    /**
     * 1015. 可被 K 整除的最小整数
     */

    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }
        int x = 1 % k;
        for (int i = 1; ; i++) {
            if (x == 0) return i;
            x = (x * 10 + 1) % k;
        }
    }

    public static void main(String[] args) {

    }
}
