package HardEX;

import java.util.Arrays;

public class LC_1547 {

    int[] ct;
    Integer[][] f = new Integer[103][103];

//    1547. 切棍子的最小成本 Rating(2116)

    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        ct = new int[m+2];
        ct[0] = 0; ct[m+1] = n;
        for (int i = 0; i < m; i++) {
            ct[i+1] = cuts[i];
        }
        Arrays.sort(ct);
        return dfs(0, ct.length-1);
    }

    int dfs(int i, int j) {
        if (i + 1 >= j) return 0;
        if (f[i][j] != null) return f[i][j];
        int ans = 0x3f3f3f3f;
        // 枚举切割点k
        for (int k = i+1; k < j; k++) {
            int v = ct[j] - ct[i];
            ans = Math.min(ans, v + dfs(i, k) + dfs(k, j));
        }
        return f[i][j] = ans;
    }

    public static void main(String[] args) {
        int n = 7;
        int[] cuts = {1, 3, 4, 5};
        System.out.println(new LC_1547().minCost(n, cuts));
    }


}
