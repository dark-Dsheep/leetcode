package Algorithm.BackTrack;

import java.util.ArrayList;
import java.util.List;

public class LC_22 {

    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, n, new StringBuilder());
        return ans;
    }

    void dfs(int lcnt, int rcnt, StringBuilder sb) {
        if (lcnt < 0 || rcnt < 0) return;
        if (lcnt == 0 && rcnt == 0) {
            ans.add(sb.toString());
            return;
        }
        if (lcnt > rcnt) return;
        // 尝试添加一个'('
        dfs(lcnt - 1, rcnt, sb.append("("));
        sb.deleteCharAt(sb.length() - 1);
        // 尝试添加一个')'
        dfs(lcnt, rcnt - 1, sb.append(")"));
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {

    }
}
