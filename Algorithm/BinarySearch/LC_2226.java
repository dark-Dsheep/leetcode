package Algorithm.BinarySearch;

import java.util.Arrays;

public class LC_2226 {

    /*
        2226. 每个小孩最多能分到多少糖果
     */
    public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        for (int x : candies) {
            sum += x;
        }
        // System.out.println("sum => "+ sum);
        if (sum < k) return 0;
        // 二分答案
        // 定义上下界
        long l = 1;
        long r = Arrays.stream(candies).max().getAsInt();

        while (l < r) {
            long mid = l + (r - l + 1) / 2;
            if (check(candies, mid, k)) {
                r = mid - 1;        // 二分左边 -> 少分点
            } else {
                l = mid;            // 二分右边 -> 多分点
            }
        }
        return (int) l;
    }

    private boolean check(int[] candies, long mid, long k) {
        // 希望给k个小孩 每个分mid个糖果
        for (int x : candies) {
            k -= x / mid;
        }
        return k > 0; // 无法给k个小孩每个分mid个
    }


    public static void main(String[] args) {
        System.out.println(new LC_2226().maximumCandies(new int[]{4, 7, 5}, 4));
    }
}
