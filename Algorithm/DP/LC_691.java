package Algorithm.DP;

import java.util.Arrays;

public class LC_691 {


//    691. 贴纸拼词

    int[] memo = new int[1 << 15];
    public int minStickers(String[] ss, String t) {
        Arrays.fill(memo, -1);
        int ans = dfs(ss, t, 0);
        return ans == 0x3f ? -1 : ans;
    }

    int dfs(String[] ss, String t, int state) {
        int n = t.length();
        if (state == ((1 << n) - 1)) return 0;
        if (memo[state] != -1) return memo[state];
        int ans = 0x3f;
        for (var str : ss) {
            int nstate = state;
            for (char c : str.toCharArray()) {
                for (int i = 0; i < n; i++) {
                    if (t.charAt(i) == c && ((nstate >> i) & 1) == 0) {
                        nstate |= (1 << i);
                        break;
                    }
                }
            }
            if (nstate != state) ans = Math.min(ans, dfs(ss, t, nstate) + 1);
        }
        memo[state] = ans; // 记忆化
        return ans;
    }

    public static void main(String[] args) {

    }
}
