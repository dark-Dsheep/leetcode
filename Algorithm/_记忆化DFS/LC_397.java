package Algorithm._记忆化DFS;

import java.util.HashMap;
import java.util.Map;

public class LC_397 {


    /*
        397. 整数替换
     */

    private Map<Long, Integer> memo = new HashMap<>();

    public int integerReplacement(int n) {
        return dfs(n);
    }

    private int dfs(long n) {
        if (n <= 1) return 0;
        if (memo.containsKey(n)) return memo.get(n);
        var res = 1;        // 中间计算结果 -> 保存在memo
        if ((n & 1) == 0) {
            res += dfs(n / 2);
        } else {
            res += Math.min(dfs(n + 1), dfs(n - 1));
        }
        memo.put(n, res); // 记忆化
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LC_397().integerReplacement(2147483647));
    }
}
