package 技巧.前缀和;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class LC_2438 {

    /*
        2438. 二的幂数组中查询范围内的乘积
     */
    private BigInteger base = BigInteger.TWO;
    private BigInteger mod = BigInteger.valueOf(Long.parseLong("1000000007"));

    public int[] productQueries(int n, int[][] queries) {
        // 求出power元素的指数集合
        // 1 2 4 8..
        // 0 1 2 3..
        var powers = new ArrayList<Integer>();
        for (int i = 0; n > 0; i++) {
            if ((n & 1) == 1) {
                powers.add(i);
            }
            n >>= 1;
        }
        int m = powers.size();
        var preSum = new long[m];
        preSum[0] = powers.get(0);
        for (int i = 1; i < m; i++) {
            preSum[i] = preSum[i - 1] + powers.get(i);
        }
        // 区间求乘积 (或者和) -> 前缀和
        var res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            if (l == 0) {
                base = base.modPow(BigInteger.valueOf(preSum[r]), mod);
            } else {
                base = base.modPow(BigInteger.valueOf(preSum[r] - preSum[l - 1]), mod);
            }
            res[i] = base.intValue();
            base = BigInteger.TWO;
        }
        return res;
    }

//    private int qpow(long a, long b, int mod) {
//        long res = 1;
//        while (b>0){
//            if((b&1)==1)
//                res = (res*a)%mod;
//            b>>=1;
//            a = (a*a)%mod;
//        }
//        return (int)res;
//    }


    public static void main(String[] args) {
        int n = 15;
        int[][] q = {{0, 1}, {2, 2}, {0, 3}};
        System.out.println(Arrays.toString(new LC_2438().productQueries(n, q)));
    }
}
