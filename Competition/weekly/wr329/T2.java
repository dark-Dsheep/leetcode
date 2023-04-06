package Competition.weekly.wr329;

import java.util.HashMap;
import java.util.PriorityQueue;

public class T2 {


    public int[][] sortTheStudents(int[][] score, int k) {

        // 第k列最大值
        int m = score.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(((o1, o2) -> {
            return o2[1] - o1[1];
        }));
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int sc = score[i][k];
            map.put(i, score[i]);
            queue.offer(new int[]{i, sc});
        }
        for (int i = 0; i < m; i++) {
            int[] p = queue.poll();
            score[i] = map.get(p[0]);
        }
        return score;
    }

    public static void main(String[] args) {

    }
}
