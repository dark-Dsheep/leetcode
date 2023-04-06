package Algorithm.BinarySearch;

import java.util.Arrays;

public class LC_1011 {

    /*
        1011. 在 D 天内送达包裹的能力
     */
    public int shipWithinDays(int[] weights, int days) {
        // 二分答案 -> 船的承载能力
        // 不能将一个包裹拆分 -> 左边界是包裹的最大重量
        int l = Arrays.stream(weights).max().getAsInt(), r = Arrays.stream(weights).sum();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(weights, mid, days)) { // 往有右找更低的运载能力
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // 判断当前船的承载能力 能否在D天内将所有物品运送完
    private boolean check(int[] weights, int mid, int days) {
        int cnt = 0, sum = 0;
        for (int w : weights) {
            if (sum + w > mid) { // 今日无法运送
                sum = 0;
                cnt++;
            }
            sum += w;
        }
        return cnt + 1 <= days;
    }

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(new LC_1011().shipWithinDays(weights, days));
//        System.out.println(new LC_1011().check(weights, 6, 3));
    }
}
