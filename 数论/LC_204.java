package 数论;

import java.util.Arrays;

public class LC_204 {

//    204. 计数质数
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        var vis = new boolean[n + 1];
        vis[0] = vis[1] = true;
        int ans = 0;
        // 埃氏筛
        for (int i = 2; i < n; i++) {
            // i是素数
            if (!vis[i]) {
                ans++;
                // 划掉i的倍数
                for (int j = i * 2; j <= n; j += i) {
                    vis[j] = true;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(cnt));
    }

    static final int N = 1001;
    static int idx = 0;
    static boolean[] st = new boolean[N];
    static int[] primes = new int[N];
    static int[] cnt = new int[N]; // cnt[x] 代表小于x的质数数量

//    static {
//        for (int i = 2; i < N; i++) {
//            if (st[i]) continue;
//            primes[idx++] = i;
//            for (int j = i + i; j < N; j += i) {
//                st[j] = true;
//            }
//        }
//        int s = 0;
//        for (int i = 2; i < N; i++) {
//            cnt[i] = s;
//            if (!st[i]) {
//                s++;
//            }
//        }
//    }

    static {
        for (int i = 2; i <= N; i++) {
            if (!st[i]) {
                primes[idx++] = i;
            }
            for (int j = 0; primes[j] <= N / i; j++) {
                st[i * primes[j]] = true;
                if (i % primes[j] == 0) {
                    break;
                }
            }
        }
        int s = 0;
        for (int i = 2; i < N; i++) {
            cnt[i] = s;
            if (!st[i]) {
                s++;
            }
        }
    }
}
