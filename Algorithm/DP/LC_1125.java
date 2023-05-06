package Algorithm.DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC_1125 {

//    1125. 最小的必要团队

    int[] mask;
    long[][] f;
    long all;

    // 状压DP
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        var sid = new HashMap<String, Integer>();
        int m = req_skills.length;
        for (int i = 0; i < m; i++) {
            sid.put(req_skills[i], i);
        }
        int n = people.size();
        mask = new int[n];
        for (int i = 0; i < n; i++) {
            for (var s : people.get(i)) {
                mask[i] |= 1 << sid.get(s);
            }
        }
        int u = 1 << m;
        f = new long[n][u];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], -1);
        }
        all = (1L << n) - 1;
        long ret = dfs(n - 1, u - 1);
        var ans = new int[Long.bitCount(ret)];
        for (int i = 0, j = 0; i < n; i++) {
            if (((ret >> i) & 1) > 0) {
                ans[j++] = i;
            }
        }
        return ans;
    }

    long dfs(int i, int j) {
        if (j == 0) return 0;
        if (i < 0) return all;
        if (f[i][j] != -1) return f[i][j];
        long a = dfs(i-1, j);
        long b = dfs(i-1, j & ~mask[i]) | (1L << i);
        return f[i][j] = Long.bitCount(a) < Long.bitCount(b) ? a : b;
    }


    public static void main(String[] args) {

    }
}
