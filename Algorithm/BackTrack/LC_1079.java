package Algorithm.BackTrack;

import java.util.Arrays;

public class LC_1079 {


//    1079. 活字印刷
    boolean[] used = new boolean[10];
    int ans = 0;

    // 类似题目 全排列II
    public int numTilePossibilities(String tiles) {
        char[] tt = tiles.toCharArray();
        Arrays.sort(tt);
        dfs(tt);
        return ans;
    }

    void dfs(char[] tt) {
        for (int i = 0; i < tt.length; i++) {
            if (used[i]) continue;                                      // 去重+1
            if (i > 0 && tt[i] == tt[i - 1] && !used[i - 1]) continue;  // 去重+1
            ans += 1;
            used[i] = true;
            dfs(tt);
            used[i] = false;
        }
    }

    public static void main(String[] args) {

    }
}
