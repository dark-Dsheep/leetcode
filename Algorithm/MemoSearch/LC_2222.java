package Algorithm.MemoSearch;

public class LC_2222 {


    private Long[][] memo;

    // TODO
    public long numberOfWays(String s) {
        memo = new Long[s.length()][4];
        var res = 0L;
        for (int i = 0; i < s.length(); i++) {
            res += dfs(s, i, 1, s.charAt(i));
        }
        return res;
    }

    private long dfs(String ss, int idx, int cnt, char pre) {
        if (cnt == 3) return 1;
        if (idx >= ss.length()) return 0;
        var cur = ss.charAt(idx);
        var res = dfs(ss, idx + 1, cnt, pre);
        if (cur != pre) {
            res += dfs(ss, idx + 1, cnt - 1, cur);
        }
        return res;
    }

    public static void main(String[] args) {
        var s = "001101";
        System.out.println(new LC_2222().numberOfWays(s));
    }
}
