package Algorithm.BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class LC_1298 {

//    1298. 你能从盒子里获得的最大糖果数

    boolean[] keyMap = new boolean[1010];
    boolean[] vis = new boolean[1010];

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        var q = new ArrayDeque<Integer>();
        var boxSet = new ArrayList<Integer>();
        for (int x : initialBoxes) {
            if (status[x] == 1) {   // 可以打开的盒子放入q
                vis[x] = true;
                q.offer(x);
            } else {
                boxSet.add(x);      // 不能打开的盒子放入boxSet,要钥匙才能打开
            }
        }
        int ans = 0;
        while (q.size() > 0) {
            int u = q.poll();
            ans += candies[u];
            for (var box : keys[u]) keyMap[box] = true;                           // 添加钥匙
            for (var box : containedBoxes[u]) { if (!vis[box]) boxSet.add(box); } // 添加盒子
            for (var box : boxSet) {             // 遍历boxSet 将可以打开的盒子加入q
                if (!vis[box] && (status[box] == 1 || keyMap[box])) {
                    vis[box] = true;
                    keyMap[box] = false;
                    q.offer(box);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
