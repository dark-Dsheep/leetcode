package Algorithm.BinarySearch;

import java.util.Arrays;

public class LC_875 {


    /*
        875. 爱吃香蕉的珂珂
     */
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        Arrays.sort(piles);
        // 二分答案 -> 对答案(速度)进行二分
        // 定义上下界
        int l = 1, r = piles[n - 1];
        while (l < r) {
            int mid = l + (r - l) / 2;
            // 如果在mid小时能够
            if (check(mid, piles, h)) {
                // 能吃掉
                r = mid;
            } else {
                // 不能吃掉, 加快速度 -> 二分右边
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int mid, int[] piles, int h) {
        // 判断速度为mid时, 能否在h小时内吃掉所有香蕉
        // 计算速度为mid, 吃掉所有香蕉用时
        int cnt = 0;
        for (int i = 0; i < piles.length; i++) {
            cnt += Math.ceil(piles[i] / (double) mid);
        }
        return cnt <= h;
    }


    public static void main(String[] args) {

        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(new LC_875().minEatingSpeed(piles, h));
    }
}
