package Algorithm.Greedy;

import java.util.PriorityQueue;

public class LC_1962 {

    /*
        1962. 移除石子使总数最小
     */
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int sum = 0;
        for (int x : piles) {
            queue.offer(x);
            sum += x;
        }
        while (k > 0) {
            int num = queue.poll();
            sum -= num / 2;
            queue.offer((num + 1) / 2); // 向下取整
            k--;
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
