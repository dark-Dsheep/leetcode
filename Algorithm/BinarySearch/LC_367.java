package Algorithm.BinarySearch;

public class LC_367 {

//    367. 有效的完全平方数
    public boolean isPerfectSquare(int num) {
        long l = 1, r = num;
        while (l < r) {
            long mid = l + r + 1 >> 1;
            if (mid * mid <= num) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l * l == num;
    }

    public static void main(String[] args) {

    }
}
