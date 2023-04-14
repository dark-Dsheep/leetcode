package Algorithm._记忆化DFS;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC_139 {

    /*
        LC_139.单词拆分
     */

    private HashSet<Integer> memo = new HashSet<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        var wordSet = new HashSet<String>(wordDict);
        return dfs(0, s, wordSet);
    }

    private boolean dfs(int start, String s, Set<String> wordSet) {
        if (start == s.length()) return true;
        for (var i = start; i < s.length(); i++) {
            if (memo.contains(i)) continue;
            if (wordSet.contains(s.substring(start, i + 1))) {
                if (dfs(i + 1, s, wordSet)) {
                    return true;
                }
                memo.add(i);    // 记忆化
            }
        }
        return false;
    }


    public static void main(String[] args) {
        var s = "leetcode";
        var wordDict = List.of("leet", "code");
        System.out.println(new LC_139().wordBreak(s, wordDict));
    }
}
