package HardEX;

import java.util.ArrayList;
import java.util.List;

public class LC_1627 {

//    1627. 带阈值的图连通性 Rating(2221)

    int[] fa;
    boolean[] st;

    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        fa = new int[n+1];
        st = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            fa[i] = i;
        }
        // 枚举公因数
        for (int z = threshold+1; z <= n; z++) {
            if (st[z]) {
                // 枚举两个z的倍数的点并合并
                for (int p = z, q = z * 2; q <= n; p += z, q += z) {
                    st[q] = true;
                    union(p, q);
                }
            }
        }
        var ans = new ArrayList<Boolean>();
        for (var q : queries) {
            ans.add(connected(q[0], q[1]));
        }
        return ans;
    }

    int find(int x) {
        while (x != fa[x]) {
            fa[x] = fa[fa[x]];
            x = fa[x];
        }
        return x;
    }

    void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;
        fa[b] = a;
    }

    boolean connected(int a, int b) {
        return find(a) == find(b);
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b % a, a);
    }

    public static void main(String[] args) {

    }
}
