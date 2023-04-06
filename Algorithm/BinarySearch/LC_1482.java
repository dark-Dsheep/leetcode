package Algorithm.BinarySearch;

import java.util.Arrays;

public class LC_1482 {

    /*
        1482. 制作 m 束花所需的最少天数
     */
    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < ((long) m * k)) return -1;
        // 二分答案
        // 确定上下界
        int l = Arrays.stream(bloomDay).min().getAsInt();
        int r = Arrays.stream(bloomDay).max().getAsInt();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(bloomDay, mid, m, k)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int[] bloomDay, int mid, int m, int k) {
        // 判断mid天 能否从花园中制作m束花, 每束花都是相邻的k朵花
        int cnt = bloomDay[0] <= mid ? 1 : 0;
        for (int i = 1; i < bloomDay.length; i++) {
            if (cnt == k) {
                cnt = 0;
                m--;
            }
            if (bloomDay[i] <= mid) {
                cnt++;
            } else {    // 不相邻了
                cnt = 0;
            }
        }
        if (cnt == k) m--;
        return m <= 0;
    }

    public static void main(String[] args) {
        int[] bloomDay = {7,7,7,7,12,7,7};
        int m = 2;
        int k = 3;
        System.out.println(new LC_1482().minDays(bloomDay, m, k));
    }
}
