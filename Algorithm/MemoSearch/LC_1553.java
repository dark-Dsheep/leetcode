package Algorithm.MemoSearch;

import java.util.HashMap;
import java.util.Map;

public class LC_1553 {

    /*
        LC.1553. 吃掉 N 个橘子的最少天数
     */
    private Map<Integer, Integer> memo = new HashMap<>();

    public int minDays(int n) {
        return dfs(n);
    }

    private int dfs(int n) {
        // System.out.println(n);
        if (n < 3) return n;
        // 存在则返回记忆化结果
        if (memo.containsKey(n)) return memo.get(n);
        // 重点: n % 2  n % 3 是剩下每天吃1个的天数
        int a = 1 + dfs(n / 2) + n % 2;  // 吃到条件2成立需要的天数
        int b = 1 + dfs(n / 3) + n % 3;  // 吃到条件3成立需要的天数
        int res = Math.min(a, b);
        memo.put(n, res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LC_1553().minDays(100000));

    }
}
