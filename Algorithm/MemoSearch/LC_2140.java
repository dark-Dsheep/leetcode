package Algorithm.MemoSearch;

import java.util.Arrays;

public class LC_2140 {

//    2140. 解决智力问题

    long[] memo;

    public long mostPoints(int[][] questions) {
        this.memo = new long[questions.length + 1];
        Arrays.fill(memo, -1);
        return dfs(questions, 0);
    }

    // 记忆化搜索
    long dfs(int[][] q, int idx) {
        if (idx >= q.length) return 0;
        if (memo[idx] != -1) return memo[idx];
        int score = q[idx][0];
        // 解决当前问题
        long a = dfs(q, q[idx][1] + idx + 1) + score;
        // 不解决当前问题
        long b = dfs(q, idx + 1);
        long ans = Math.max(a, b);
        memo[idx] = ans;    // 记忆化
        return ans;
    }

    public static void main(String[] args) {
        int[][] q = {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}};
        System.out.println(new LC_2140().mostPoints(q));
    }
}
