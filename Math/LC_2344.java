package Math;

import java.util.Arrays;

public class LC_2344 {

//    2344. 使数组可以被整除的最少删除次数


    public int minOperations(int[] nums, int[] numsDivide) {
        // 求出numsDivide的最大公约数 g
        // 看看nums中最小的数能不能整除 g,不能就删除
        int g = 0;
        for (int x : numsDivide)  {
            if (g == x) continue;
            g = gcd(x, g);
        }
        Arrays.sort(nums);
        int res = 0;
        for (int x : nums) {
            if (g % x == 0) break;
            res++;
        }
        return res == nums.length ? -1 : res;
    }


    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {

        int[] numsDivide = {8,2,6,10};
        int[] nums = {4,3,6};
        System.out.println(new LC_2344().minOperations(nums, numsDivide));
    }
}
