package Algorithm.BFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LC_403 {

    /*
        403. 青蛙过河
     */

    private Map<Integer, Integer> map = new HashMap<>();
    private boolean[][] vis = new boolean[2010][2010]; //

    public boolean canCross(int[] stones) {
        // 带标记的bfs
        for (var i = 0; i < stones.length; i++) {
            map.put(stones[i], i);
        }
        if (!map.containsKey(1)) return false;
        var queue = new LinkedList<int[]>();
        queue.offer(new int[]{1, 1});
        vis[1][1] = true;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            var idx = p[0];
            var k = p[1];
            if (idx == stones.length - 1) return true;
            // 三种情况: k - 1, k, k + 1
            for (var i = -1; i <= 1; i++) {
                if (k + i == 0) continue;
                var nStone = stones[idx] + k + i;       // 下一个石头
                var nK = k + i;
                if (!map.containsKey(nStone)) continue; // 不存在下一个石头
                var nIdx = map.get(nStone);
                if (!vis[nIdx][nK]) {        // 检查以nK到达该nIdx的情况是否访问过
                    vis[nIdx][nK] = true;
                    queue.offer(new int[]{nIdx, nK});
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
