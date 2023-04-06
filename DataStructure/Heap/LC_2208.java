package DataStructure.Heap;

import java.util.PriorityQueue;

public class LC_2208 {

    /*
        2208. 将数组和减半的最少操作次数
     */
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>(((o1, o2) -> Double.compare(o2, o1)));
        double sum = 0, half = 0;
        for (int x : nums) {
            sum += x;
            pq.offer((double) x);
        }
        half = sum / 2;
        int res = 0;
        while (sum > half && !pq.isEmpty()) {
            double p = pq.poll();
            sum = sum - p / 2.0;
            p /= 2.0;
            pq.offer(p);
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5, 19, 8, 1};
        System.out.println(new LC_2208().halveArray(nums));
    }
}
