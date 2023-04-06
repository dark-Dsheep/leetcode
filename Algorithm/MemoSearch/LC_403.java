package Algorithm.MemoSearch;

import java.util.HashMap;
import java.util.Map;

public class LC_403 {


    /*
        403. 青蛙过河
    */
    private Map<Integer, Integer> map = new HashMap<>();
    private Map<Integer, Boolean> memo = new HashMap<>(); // 记忆化cache

    public boolean canCross(int[] stones) {
        for (var i = 0; i < stones.length; i++) {
            map.put(stones[i], i);
        }
        if (!map.containsKey(1)) return false;
        return dfs(stones, stones.length, 1, 1);
    }

    private boolean dfs(int[] stones, int n, int idx, int k) {
        var key = idx * 10000 + k;                  // key值可以这样映射
        if (memo.containsKey(key)) return memo.get(key);
        if (idx == n - 1) return true;
        boolean res = false;                         // 中间计算结果
        for (var i = -1; i <= 1; i++) {
            if (i + k == 0) continue;               // 原地跳
            var nStone = stones[idx] + k + i;
            if (!map.containsKey(nStone)) continue; // 下一个石头不存在
            var nIdx = map.get(nStone);
            var nK = k + i;
            res |= dfs(stones, n, nIdx, nK);
            if (res) break;                         // 提前退出
        }
        memo.put(key, res);                         // 记忆化
        return res;
    }

    public static void main(String[] args) {
        var stones = new int[] {0, 1, 3, 5, 6, 8, 12, 17};
        System.out.println(new LC_403().canCross(stones));
    }
}
