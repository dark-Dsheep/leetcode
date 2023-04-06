package DataStructure.Heap;

import java.util.PriorityQueue;

public class LC_1921 {

    /*
        1921. 消灭怪物的最大数量
     */
    public int eliminateMaximum(int[] dist, int[] speed) {
       PriorityQueue<Integer> queue = new PriorityQueue<>((Integer::compare));
       int n = dist.length;
       // 贪心思路：击杀当前时刻距离最近的怪物
       for (int i = 0; i < n; i++) {
           // 计算出每个怪物到达城市前的最晚可被消灭时间
           queue.offer((dist[i] + speed[i] - 1) / speed[i]);
       }
       int cnt = 0;
       while (!queue.isEmpty()) {
           int p = queue.poll();
           if (p <= cnt) {
               break;
           }
           cnt++;
       }
       return cnt;
    }

    public static void main(String[] args) {
        int[] dist = {1, 1, 2, 3}, speed = {1, 1, 1, 1};
        System.out.println(new LC_1921().eliminateMaximum(dist, speed));
    }
}
