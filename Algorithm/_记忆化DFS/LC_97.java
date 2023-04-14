package Algorithm._记忆化DFS;

public class LC_97 {


    private String s1;
    private String s2;
    private String s3;
    private Boolean[][] memo = new Boolean[110][110];

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        return dfs(0, 0, 0);
    }
    // 记忆化搜索: i,j两个状态
    private boolean dfs(int i, int j, int idx) {
        if (idx >= s3.length()) return true; // 合法解
        if (memo[i][j] != null) return memo[i][j];
        var res = false;
        // DFS两种状态：选s1的一个字符,选s2的一个字符
        if (i + 1 <= s1.length() && s1.charAt(i) == s3.charAt(idx)) {
            res |= dfs(i + 1, j, idx + 1);
        }
        if (j + 1 <= s2.length() && s2.charAt(j) == s3.charAt(idx)) {
            res |= dfs(i, j + 1, idx + 1);
        }
        memo[i][j] = res; // 记忆化
        return res;
    }

    public static void main(String[] args) {

        System.out.println(new LC_97().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
