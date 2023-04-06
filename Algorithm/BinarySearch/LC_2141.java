package Algorithm.BinarySearch;

import java.util.Arrays;

public class LC_2141 {


    /*
        2141. 同时运行 N 台电脑的最长时间
        TODO
     */
    public long maxRunTime(int n, int[] batteries) {
        // 二分答案
        // 定义上下界
        long l = 1;
        long r = Arrays.stream(batteries).sum() / n;

        while (l < r) {
            long mid = l + (r - l + 1) / 2;
            if (check(batteries, mid, n)) {
                l = mid;
            } else {
                r = mid - 1;     // 二分左边 -> 减少同时运行时间
            }
        }
        return l;
    }

    private boolean check(int[] batteries, long mid, int n) {
        // 能否让n 台电脑同时运行 mid分钟
        // 10 10 3 5
        long less = 0;
        for (int x : batteries) {
            if (x > mid) {
                less += x - mid;
            } else {
                less += x;
            }
        }
        return n * mid <= less;
    }

    public static void main(String[] args) {
        int[] batteries = {18, 54, 2, 53, 87, 31, 71, 4, 29, 25};
        int n = 9;
//        System.out.println(new LC_2141().maxRunTime(n, batteries));


        System.out.println(11 / 3);
    }
}
