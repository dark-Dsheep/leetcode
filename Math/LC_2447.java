package Math;

public class LC_2447 {

    /*
        2447. 最大公因数等于 K 的子数组数目
     */
    public int subarrayGCD(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            // 剪枝: 以i位置开始的子数组,若nums[i]不可以被k整除,则无需继续
            if (nums[i] % k != 0) continue;
            int g = 0;
            // 求a,b,c,d的最大公约数过程
            // a与b的最大公约数x -> x与c的最大公约数y -> y与d的最大公约数z
            for (int j = i; j < n; j++) {
                g = gcd(g ,nums[j]);
                if (g < k) break; // 最大公约数小于k,提前退出
                if (g == k) res++;
            }
        }
        return res;
    }

    private int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }

    public static void main(String[] args) {

    }
}
