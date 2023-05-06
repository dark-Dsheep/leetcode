package DataStructure.线段树;

import java.util.Arrays;

public class LC_2569 {

//    6358. 更新数组后处理求和查询

    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        int n = nums1.length, m = 0, idx = 0;
        for (int i = 1; i <= n; i++) a[i] = nums1[i - 1];
        buildTree(1, 1, n);
        long sum = Arrays.stream(nums2).sum();
        for (var q : queries) if (q[0] == 3) m++;
        var ans = new long[m];
        for (var q : queries) {
            int t = q[0];
            if (t == 1) update(1, 1, n, q[1] + 1, q[2] + 1);
            else if (t == 2) sum += (long) q[1] * f[1];
            else ans[idx++] = sum;
        }
        return ans;
    }

    static final int N = 100001;
    int[] a = new int[N];
    int[] f = new int[4*N]; // f[k] 表示编号为k的区间 1的个数
    boolean[] v = new boolean[4*N];

    void buildTree(int k, int l, int r) {
        if (l == r) {
            f[k] = a[l];
            return;
        }
        int m = (l + r) >> 1;
        buildTree(k << 1, l, m);
        buildTree(k << 1 | 1, m + 1, r);
        f[k] = f[k << 1] + f[k << 1 | 1];
    }
    // 更新 [L, R]
    void update(int k, int l, int r, int L, int R) {
        if (L <= l && r <= R) {
            do_(k, l, r);
            return;
        }
        int m = (l + r) >> 1;
        // 需要继续递归, 就把v[k]的内容下放给左右儿子
        if (v[k]) {
            do_(k << 1, l, r);
            do_(k << 1 | 1, l, r);
            v[k] = false;
        }
        if (m >= L) update(k << 1, l, m, L, R);
        if (m < R) update(k << 1 | 1, m + 1, r, L, R);
        f[k] = f[k << 1] + f[k << 1 | 1];
    }

    void do_(int k, int l, int r) {
        f[k] = r - l + 1 - f[k]; // 翻转
        v[k] = !v[k];
    }


    public static void main(String[] args) {
        int[] A = {1, 0, 1};
        int[] B = {0, 0, 0};
        int[][] q = {{1, 1, 1}, {2, 1, 0}, {3, 0, 0}};
        System.out.println(Arrays.toString(new LC_2569().handleQuery(A, B, q)));
    }
}
