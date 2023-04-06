package Math;

public class LC_342 {

    /*
        342. 4的幂
     */
    public boolean isPowerOfFour(int n) {
        // 试除法
        if (n <= 0) return false;
        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }



    public static void main(String[] args) {
        System.out.println(new LC_342().isPowerOfFour(16));
    }
}
