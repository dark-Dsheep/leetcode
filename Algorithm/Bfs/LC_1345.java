package Algorithm.Bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC_1345 {

//    1345. 跳跃游戏 IV

    public int minJumps(int[] arr) {
        int n = arr.length;
        var vis = new boolean[n + 1];
        var map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        var q = new ArrayDeque<int[]>(); // {节点, 步数}
        q.offer(new int[]{0, 0});
        vis[0] = true;
        while (q.size() > 0) {
            var p = q.poll();
            int u = p[0], step = p[1];
            if (u == n - 1) return step;
            // i + 1
            if (u + 1 < n && !vis[u + 1]) {
                vis[u + 1] = true;
                q.offer(new int[]{u + 1, step + 1});
            }
            // i - 1
            if (u - 1 >= 0 && !vis[u - 1]) {
                vis[u - 1] = true;
                q.offer(new int[]{u - 1, step + 1});
            }
            // arr[i] == arr[j]
            if (!map.containsKey(arr[u])) continue;
            var list = map.get(arr[u]);
            for (int next : list) {
                if (next - u != 0 && !vis[next]) {
                    vis[next] = true;
                    q.offer(new int[] {next, step + 1});
                }
            }
            map.remove(arr[u]); // 关键: 避免重复访问
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {100,-23,-23,404,100,23,23,23,3,404};
        System.out.println(new LC_1345().minJumps(arr));
    }
}
