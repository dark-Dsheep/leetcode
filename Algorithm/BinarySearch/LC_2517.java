package Algorithm.BinarySearch;

import java.util.Arrays;

public class LC_2517 {

    /*
        2517. 礼盒的最大甜蜜度
     */
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        long l = 0;
        long r = Arrays.stream(price).max().getAsInt();
        while (l < r) {
            long mid = l + (r - l + 1) / 2;
            if (check(price, mid, k)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return (int) l;
    }

    // 判断选出k类糖果 的甜蜜度能否到达mid
    private boolean check(int[] price, long mid, int k) {
        // 1 2 5 8 13 21
        // mid = 8
        int cnt = 1;
        int pre = price[0];
        for (int i = 1; i < price.length; i++) {
            if (Math.abs(price[i] - pre) >= mid) {
                cnt++;
                pre = price[i];
            }
        }
        return cnt >= k;
    }


    public static void main(String[] args) {

        int[] price = {13, 5, 1, 8, 21, 2};
        int k = 3;
        System.out.println(new LC_2517().maximumTastiness(price, k));
    }
}
