package Algorithm.BackTrack;

import java.util.ArrayList;
import java.util.List;

public class LC_131 {


    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();
    String ss;

    public List<List<String>> partition(String s) {
        ss = s;
        dfs(0);
        return ans;
    }

    void dfs(int start) {
        if (start == ss.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 枚举子串结束位置
        for (int i = start; i < ss.length(); i++) {
            if (check(start, i)) {
                path.add(ss.substring(start, i + 1));
                dfs(i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    boolean check(int i, int j) {
        while (i < j) {
            if (ss.charAt(i++) != ss.charAt(j--)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        var s = "aab";
        System.out.println(new LC_131().partition(s));
    }
}
