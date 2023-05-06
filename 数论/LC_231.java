package 数论;

public class LC_231 {

    /*
        231. 2 的幂
     */

    // 数学做法
    public boolean isPowerOfTwo(int n) {
        // n > 0 将n除2 判断n能不能被2整除 直到n=1
        if (n <= 0) return false;
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }
    // 位运算
    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(new LC_231().isPowerOfTwo2(16));
    }
}
