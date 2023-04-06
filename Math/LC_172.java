package Math;

import java.math.BigInteger;

public class LC_172 {


    /*
        172. 阶乘后的零
     */
    //TODO
    public int trailingZeroes(int n) {
        if (n == 0) return 0;
        BigInteger num = jc(n);
        String s = num.toString();
        int cnt = 0;
        int k = s.length() - 1;
        while (s.charAt(k) == '0') {
            cnt += 1;
            k--;
        }
        return cnt;
    }

    public BigInteger jc(int a) {
        BigInteger ret = BigInteger.valueOf(a);
        if (a == 1) {
            return BigInteger.valueOf(a);
        }
        return ret.multiply(jc(a - 1)); // 乘法
    }

    public static void main(String[] args) {

        System.out.println(new LC_172().trailingZeroes(11));
    }
}
