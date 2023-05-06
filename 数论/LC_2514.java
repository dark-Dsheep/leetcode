package 数论;

import java.util.Arrays;

public class LC_2514 {


    // 组合逆元模板

    static class Combination {
        static final long DEFAULT_MOD = 1000000007;
        int n;
        long mod = DEFAULT_MOD;
        long[] fact;
        long[] ifact;

        public Combination(int n) {
            this(n, DEFAULT_MOD);
        }

        public Combination(int n, long mod) {
            this.n = n;
            this.mod = mod;
            initialize();
        }

        // 预计算组合的逆元
        void initialize() {
            // 逆元线性筛
            fact = new long[n+1];
            ifact = new long[n+1];

            long[] inv = new long[n+1];
            inv[1] = 1;
            for (int i = 2; i <= n; i++) {
                inv[i] = (mod - mod / i) * inv[(int) (mod % i)] % mod;
            }
            fact[0] = ifact[0] = 1;
            for (int i = 1; i <= n; i++) {
                fact[i] = fact[i-1] * i % mod;
                ifact[i] = ifact[i-1] * inv[i] % mod;
            }
        }

        // 计算C(n,k)
        long comb(int n, int k) {
            return fact[n] * ifact[k] % mod * ifact[n-k] % mod;
        }
    }

    static class CombinationUtils {
        static boolean ok = false;
        static Combination combination;

        static void init(int n, long mod) {
            if (ok) return;
            ok = true;
            combination = new Combination(n, mod);
        }

        static long comb(int n, int k) {
            return combination.comb(n, k);
        }
    }


    static long MOD = 1000000007;

    long solve(String s) {
        int[] mp = new int[26];
        for (char c : s.toCharArray()) {
            mp[c-'a']++;
        }
        // 排列的计算
        int n = s.length();
        long ans = 1L;
        for (int i = 0; i < 26; i++) {
            if (mp[i] > 0) {
                // 调用
                ans = ans * CombinationUtils.comb(n, mp[i]) % MOD;
                n = n - mp[i];
            }
        }
        return ans;
    }

    public int countAnagrams(String s) {

        CombinationUtils.init(100000, MOD);
        return Arrays.stream(s.split("\\s+"))
                .map(x -> solve(x))
                .reduce(1L, (a, b) -> a * b % MOD).intValue();
    }

    public static void main(String[] args) {

    }


}
