package Competition.weekly.wr330;

import java.math.BigInteger;

public class T2 {

    public int monkeyMove(int n) {
        BigInteger a = new BigInteger("2");
        BigInteger b = new BigInteger("" + n);
        BigInteger p = new BigInteger("1000000007");
        int res = a.modPow(b, p).intValue();
        return (res - 2 + 1000000007) % 1000000007;
    }

    public int monkeyMove2(int n) {
        int mod = (int)1e9+7;
        long res = 1;
        long v = 2;
        while(n>0) {
            int t = (n&1);
            if(t==1) {
                res = res * v % mod;
            }
            v = v * v % mod;
            n = n >> 1;
        }
        res = (res-2 + mod) % mod;
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(new T2().monkeyMove2(500000003));
    }
}
