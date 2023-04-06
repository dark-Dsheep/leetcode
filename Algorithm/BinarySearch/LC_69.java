package Algorithm.BinarySearch;

public class LC_69 {

//    69. x 的平方根
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int l = 0, r = x;
        while (l < r) {
            int mid = l + r >> 1;
            if ((long) mid * mid <= x) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l - 1;
    }


    public static void main(String[] args) {

    }
}
