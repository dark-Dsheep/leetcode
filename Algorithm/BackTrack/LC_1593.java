package Algorithm.BackTrack;

import java.util.HashSet;

public class LC_1593 {


//    1593. 拆分字符串使唯一子字符串的数目最大

    HashSet<String> set = new HashSet<>();
    String ss;
    int ans;
    // 类似题目 LC131. 分割回文串
    public int maxUniqueSplit(String s) {
        ss = s;
        dfs(0, 0);
        return ans;
    }

    void dfs(int start, int cnt) {
        if (start == ss.length()) {
            ans = Math.max(ans, cnt);
            return;
        }
        for (int i = start; i < ss.length(); i++) {
            var s = ss.substring(start, i + 1);
            if (!set.contains(s)) {
                set.add(s);
                dfs(i + 1, cnt + 1);             // dfs下一层
                // 恢复现场
                set.remove(s);
            }
        }
    }

    public static void main(String[] args) {

    }
}
