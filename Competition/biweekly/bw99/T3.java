package Competition.biweekly.bw99;

import java.math.BigInteger;
import java.util.Arrays;

public class T3 {

    static BigInteger MOD = BigInteger.valueOf((long) 1e9 + 7);

    public int countWays(int[][] r) {
        // 将区间按照start排序
        Arrays.sort(r, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        var cur = r[0];
        int m = 1;
        for (int i = 1; i < r.length; i++) {
            if (cur[1] >= r[i][0]) { // 合并为一组
                cur[1] = Math.max(cur[1], r[i][1]);
            } else { // 划分新的组
                m++;
                cur = r[i];
            }
        }
        var base = BigInteger.valueOf(m);
        // 方案数 = 2 ^ m组 m可能很大选择使用快速幂
        int ans = BigInteger.TWO.modPow(base, MOD).intValue();
        return ans;
    }

    public static void main(String[] args) {

    }
}
