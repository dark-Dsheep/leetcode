package Algorithm.BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_841 {

    boolean[] vis;
    int crossCnt;

    /*
        841. 钥匙和房间
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        vis = new boolean[n];
        vis[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while(!queue.isEmpty()) {
            int x = queue.poll();
            crossCnt++;         // 经过房间数 +1
            for (int i : rooms.get(x)) {
                if (!vis[i]) {
                    vis[i] = true;
                    queue.offer(i);
                }
            }
        }
        return crossCnt == n;
    }

    public static void main(String[] args) {

    }
}
