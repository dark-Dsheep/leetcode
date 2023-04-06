package Math;

public class LC_1250 {

//    1250. 检查「好数组」

    // 裴蜀定理
    // 设a,b是全不为零的整数 则存在整数x,y 使得ax + by = gcd(a, b)
    // 进一步可以推广到a,b,c,d...n个数

    public boolean isGoodArray(int[] nums) {
        int g = 0;
        for (int x : nums) {
            g = gcd(g, x);
        }
        return g == 1;
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {

    }
}
