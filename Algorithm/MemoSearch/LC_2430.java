package Algorithm.MemoSearch;

public class LC_2430 {

    //    2430. 对字母串可执行的最大删除数 TODO
    Integer[] memo = new Integer[4010];

    public int deleteString(String s) {
        return dfs(s, 0);
    }

    // 两种操作
    // case1 删除整个字符串s -> 这个操作只会让答案变小
    // case2 对于当前i,如果s的前i个字母与s的后i个字母相等,删除s前i个字母 考虑
    int dfs(String s, int start) {
        int len = s.length();
        if (start >= len) return 0;
        if (memo[start] != null) return memo[start];
        int ans = 1;
        for (int i = start + 1; i < len; i++) {
            if (i > (len - start) / 2) break;
            var a = s.substring(start, i);          // 前i个
            var b = s.substring(i, i+a.length()); // 后i个
            if (a.equals(b)) {
                ans = Math.max(ans, 1+dfs(s, i));
            }
        }
        memo[start] = ans;
        return ans;
    }

    public static void main(String[] args) {
        var s = "abcabcdabc";
        System.out.println(new LC_2430().deleteString(s));
    }
}
