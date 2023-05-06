package Algorithm.DP;

public class LC_1278 {

//    1278. 分割回文串 III

    public int palindromePartition(String s, int k) {
        int N = s.length(), K = k;
        s = " " + s;
        // 区间dp
        // dp[i][k] 表示s[1:i]能够分成k个子串,每个子串都是回文串的最小修改字符数、
        var dp = new int[N + 1][K + 1];
        // 初始化 k=1的时候 dp[i][k]的值
        for (int i = 1; i <= N; i++) dp[i][1] = cost(s, 1, i);
        dp[0][0] = 0;
        for (int i = 1; i <= N; i++) {
            for (k = 2; k <= Math.min(i, K); k++) {
                dp[i][k] = 0x3f3f3f;
                for (int j = i; j >= k; j--) {
                    dp[i][k] = Math.min(dp[i][k], dp[j - 1][k - 1] + cost(s, j, i));
                }
            }
        }
        return dp[N][K];
    }

    // 计算将s[j:i]变为回文串的修改次数
    int cost(String s, int j, int i) {
        int cnt = 0;
        for ( ; j < i; ++j, --i) {
            if (s.charAt(j) != s.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        var s = "abc";
        int k = 2;
        System.out.println(new LC_1278().palindromePartition(s, k));
    }
}
