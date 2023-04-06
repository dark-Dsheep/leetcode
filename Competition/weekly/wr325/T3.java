package Competition.weekly.wr325;

import java.util.Arrays;

public class T3 {

//     礼盒的最大甜蜜度
//    给你一个正整数数组 price ，其中 price[i] 表示第 i 类糖果的价格，另给你一个正整数 k 。
//
//    商店组合 k 类 不同 糖果打包成礼盒出售。礼盒的 甜蜜度 是礼盒中任意两种糖果 价格 绝对差的最小值。
//
//    返回礼盒的 最大 甜蜜度。

//    输入：price = [13,5,1,8,21,2], k = 3
//    输出：8
//    解释：选出价格分别为 [13,5,21] 的三类糖果。
//    礼盒的甜蜜度为 min(|13 - 5|, |13 - 21|, |5 - 21|) = min(8, 8, 16) = 8 。
//    可以证明能够取得的最大甜蜜度就是 8 。

    public int maximumTastiness(int[] price, int k) {
        int left = 0, right = 1000000000;
        for (Arrays.sort(price); left < right; ) {
            int mid = (left + right + 1) / 2;
            int count = 1;
            for (int i = 1, prev = 0; i < price.length; i++) {
                if (price[i] - price[prev] >= mid) {
                    count++;
                    prev = i;
                }
            }
            if (count < k) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] price = {13, 5, 1, 8, 21, 2};
        int k = 3;
        System.out.println(new T3().maximumTastiness(price, k));
    }
}
