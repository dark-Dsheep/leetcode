package Algorithm.DP;


public class LC_2370 {

//    2370. 最长理想子序列
    Integer[][] memo = new Integer[100010][26];
    char[] ss;
    int k;
    public int longestIdealString(String s, int _k) {
        ss = s.toCharArray();
        k = _k;
        // dp做法
        // int n = s.length();
        // var dp = new int[26];
        // for (var c : s.toCharArray()) {
        //     int x = c - 'a';
        //     int lo = Math.max(0, x-k), hi = Math.min(25, x+k);
        //     for (int j = lo; j <= hi; j++) {
        //         dp[x] = Math.max(dp[x], dp[j]);
        //     }
        //     dp[x] += 1;
        // }
        // return Arrays.stream(dp).max().getAsInt();
        int ans = 0;
        for (int i = 0; i < ss.length; i++) {
            ans = Math.max(ans, dfs(i, ss[i]));
        }
        return ans;
    }

    int dfs(int pos, char pre) {
        if (pos >= ss.length) return 0;
        if (memo[pos][pre-'a'] != null) {
            return memo[pos][pre-'a'];
        }
        int ans = 0;
        if (Math.abs(ss[pos] - pre) <= k) {     // 两种选择 将ss[pos]加入到最长理想子序列 或者不加入
            ans = Math.max(1 + dfs(pos+1, ss[pos]), dfs(pos+1, pre));
        } else {
            ans = dfs(pos+1, pre);          // 只能选择不加入
        }
        memo[pos][pre-'a'] = ans;
        return ans;
    }


    public static void main(String[] args) {
        var s = "acfgbd";
        int k = 2;
        System.out.println(new LC_2370().longestIdealString(s, k));
    }
}
