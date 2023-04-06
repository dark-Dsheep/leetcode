package Algorithm.BinarySearch;

import java.util.Arrays;

public class LC_1385 {


//    1385. 两个数组间的距离值

    public int findTheDistanceValue(int[] a, int[] b, int d) {
        Arrays.sort(b);
        int ans = 0;
        for (int x : a) {
            int l = 0, r = b.length - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (Math.abs(b[mid] - x) > d && b[mid] > x) {
                    r = mid;
                } else if (Math.abs(b[mid] - x) > d && b[mid] < x){
                    l = mid + 1;
                } else if (Math.abs(b[mid] - x) <= d){
                    break;
                }
            }
            if (l == r && Math.abs(b[l] - x) > d) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
