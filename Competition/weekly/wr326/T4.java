package Competition.weekly.wr326;

import java.util.ArrayList;
import java.util.Arrays;

public class T4 {

//    范围内最接近的两个质数
//    给你两个正整数 left 和 right ，请你找到两个整数 num1 和 num2 ，它们满足：
//
//    left <= nums1 < nums2 <= right  。
//    nums1 和 nums2 都是 质数 。
//    nums2 - nums1 是满足上述条件的质数对中的 最小值 。
//    请你返回正整数数组 ans = [nums1, nums2] 。如果有多个整数对满足上述条件，请你返回 nums1 最小的质数对。如果不存在符合题意的质数对，请你返回 [-1, -1] 。
//
//    如果一个整数大于 1 ，且只能被 1 和它自己整除，那么它是一个质数

//    输入：left = 10, right = 19
//    输出：[11,13]
//    解释：10 到 19 之间的质数为 11 ，13 ，17 和 19 。
//    质数对的最小差值是 2 ，[11,13] 和 [17,19] 都可以得到最小差值。
//    由于 11 比 17 小，我们返回第一个质数对。

    private static ArrayList<Integer> list = new ArrayList<>() {
        {
            Boolean[] prime = new Boolean[1000000];
            for (int i = 2; i < 1000000; i++) {
                if (prime[i] == null) {
                    add(i);
                    for (int j = 2 * i; j < 1000000; j += i) {
                        prime[j] = true;
                    }
                }
            }
        }
    };

    public int[] closestPrimes(int left, int right) {
        int[] result = {-1, -1};
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) >= left && list.get(i) <= right) {
                if ((result[0] < 0 || list.get(i) - list.get(i - 1) < result[1] - result[0])) {
                    result = new int[]{list.get(i - 1), list.get(i)};
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new T4().closestPrimes(10, 19)));
    }
}
