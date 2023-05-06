package 数论;

import java.util.HashSet;

public class LC_2521 {

    /*
        2521. 数组乘积中的不同质因数数目
     */

    public int distinctPrimeFactors(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) {
            int i = 2;
            while (i * i <= x) {    // 质因数分解
                if (x % i == 0) {   // 判断i是不是x的因子
                    set.add(i);
                    x = x / i;
                    while (x % i == 0) {
                        x = x / i;
                    }
                }
                i += 1;
            }
            if (x > 1) set.add(x);
        }
        return set.size();
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 7, 10, 6};
        System.out.println(new LC_2521().distinctPrimeFactors(nums));
    }
}
