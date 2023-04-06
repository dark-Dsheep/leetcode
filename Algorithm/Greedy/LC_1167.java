package Algorithm.Greedy;

import java.util.PriorityQueue;

public class LC_1167 {

    /*
        1167. 连接棒材的最低费用
     */
    public int connectSticks(int[] sticks) {
        // 贪心思路：每次合成最低价格的棍子
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int x : sticks) queue.offer(x);
        int cost = 0;
        while (!queue.isEmpty() && queue.size() > 1) {
            int p1 = queue.poll();
            int p2 = queue.poll();
            cost += p1 + p2;
            queue.offer(p1 + p2);
        }
        return cost;
    }


    public static void main(String[] args) {

    }
}
