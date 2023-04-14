package Algorithm._记忆化DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC_2008 {

//    2008. 出租车的最大盈利

    int N;
    long[] f = new long[100010];
    HashMap<Integer, List<int[]>> mp = new HashMap<>();

    public long maxTaxiEarnings(int n, int[][] rides) {
        N = n;
        Arrays.fill(f, -1);
        for (var r : rides) {  // 将start相同的订单分组保存
            r[2] = r[1] - r[0] + r[2];
            mp.computeIfAbsent(r[0], v -> new ArrayList<>()).add(r);
        }
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dfs(i));
        }
        return ans;
    }
    // dfs[i]表示以i出发可以获得的最大收益
    long dfs(int i) {
        if (i > N) return 0;
        if (f[i] != -1) return f[i];
        long ans = 0;
        ans = dfs(i + 1);
        if (mp.containsKey(i)) {
            for (var r : mp.get(i)) {
                ans = Math.max(ans, r[2] + dfs(r[1]));
            }
        }
        return f[i] = ans;
    }


    public static void main(String[] args) {
        int n = 5;
        int[][] r = {{2, 5, 4}, {1, 5, 1}};
        System.out.println(new LC_2008().maxTaxiEarnings(n, r));
    }
}
