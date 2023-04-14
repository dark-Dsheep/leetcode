package Algorithm._记忆化DFS;

import java.util.Arrays;

public class LC_1235 {


//    1235. 规划兼职工作

    int[] f = new int[50010];
    int[][] a;
    int n;

    public int jobScheduling(int[] st, int[] ed, int[] pf) {
        n = pf.length;
        Arrays.fill(f, -1);
        a = new int[n][3];
        for (int i = 0; i < n; i++) {
            a[i] = new int[]{st[i], ed[i], pf[i]};
        }
        Arrays.sort(a, (x, y) -> x[0] - y[0]);
        return dfs(0);
    }

    int dfs(int i) {
        if (i >= n) return 0;
        if (f[i] != -1) return f[i];
        int ans = dfs(i + 1);
        int ed = a[i][1], v = a[i][2];
        // 二分答案找第i份工作结束之后, 开始的第一个工作
        int l = i + 1, r = n;
        while (l < r) {
            int mid = l + r >> 1;
            if (a[mid][0] >= ed) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        ans = Math.max(ans, v + dfs(l));
        return f[i] = ans;
    }



    public static void main(String[] args) {
        int[] st = {1, 2, 3, 3};
        int[] ed = {3, 4, 5, 6};
        int[] pr = {50, 10, 40, 70};
        System.out.println(new LC_1235().jobScheduling(st, ed, pr));
    }
}
