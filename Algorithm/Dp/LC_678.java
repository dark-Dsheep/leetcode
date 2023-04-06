package Algorithm.Dp;

public class LC_678 {

    private Boolean[][] memo = new Boolean[110][110];

    public boolean checkValidString(String s) {
        return dfs(s, 0, 0);
    }

    /**
     * @param s        字符串
     * @param idx      当前位置索引
     * @param leftCnt  当前位置左括号数量
     * @return
     */
    private boolean dfs(String s, int idx, int leftCnt) {
        if (idx == s.length()) {
            if (leftCnt == 0) return true; // 左括号必须全部匹配完,才合法
            else return false;
        }
        if (memo[idx][leftCnt] != null) {
            return memo[idx][leftCnt];
        }
        var c = s.charAt(idx);
        boolean res = false;
        if (c == '(') {
            // 继续向前搜索 匹配右括号或者 '*'
            res |= dfs(s, idx + 1, leftCnt + 1);
        } else if (c == ')') {
            // 可以抵消一个左括号
            if (leftCnt <= 0) return false; // 没有左括号了 多余的右括号
            res |= dfs(s, idx + 1, leftCnt - 1);
        } else if (c == '*') {
            // '*' 有三种选择
            // 1. 作为一个左括号
            res |= dfs(s, idx + 1, leftCnt + 1);
            if (leftCnt > 0) {              // 还有左括号,用'*'作为一个右括号
                // 2. 作为一个右括号
                res |= dfs(s, idx + 1, leftCnt - 1);
            }
            // 3. 作为一个空字符
            res |= dfs(s, idx + 1, leftCnt);
        }
        memo[idx][leftCnt] = res;   // 记忆化
        return res;
    }


    public static void main(String[] args) {

    }
}
