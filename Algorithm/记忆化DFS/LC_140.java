package Algorithm.记忆化DFS;

import java.util.*;

public class LC_140 {


    /*
        140. 单词拆分 II
     */

    private Set<String> wordSet = new HashSet<>();
    private List<String> res = new ArrayList<>();
    private Map<Integer, List<String>> memo = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        wordSet.addAll(wordDict);
        return dfs(0, s);
    }

    // 记忆化dfs
    private List<String> dfs(int start, String s) {
        if (memo.containsKey(start)) return memo.get(start);
        if (start == s.length()) return List.of("");
        var res = new ArrayList<String>();
        for (var i = start; i < s.length(); i++) {
            var temp = s.substring(start, i + 1);
            if (wordSet.contains(temp)) {
                // 考虑最后一个单词
                List<String> last = dfs(i + 1, s);
                for (var l : last) {
                    if (!l.equals("")) res.add(temp + " " + l);
                    else res.add(temp);
                }
            }
        }
        memo.put(start, res);
        return res;
    }





    // 暴力回溯
//    private void dfs(int start, String s, LinkedList<String> path) {
//        //
//        if (start == s.length()) {
//            var sb = new StringBuilder();
//            for (var word : path) sb.append(word).append(" ");
//            res.add(sb.toString().trim());
//            return;
//        }
//        for (var i = start; i < s.length(); i++) {
//           var temp = s.substring(start, i + 1);
//           if (wordSet.contains(temp)) {
//               path.add(temp);
//               dfs(i + 1, s, path);
//               // 恢复现场
//               path.removeLast();
//           }
//       }
//    }

    public static void main(String[] args) {
        var s = "catsanddog";
        var wordDict = List.of("cat", "cats", "and", "sand", "dog");
        System.out.println(new LC_140().wordBreak(s, wordDict));
    }
}
