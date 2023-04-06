package Competition.weekly.wr327;

import java.util.PriorityQueue;

public class T2 {

    public static long maxKelements2(int[] nums, int k) {
        PriorityQueue<Long> queue = new PriorityQueue<>(((o1, o2) -> Math.toIntExact(o2 - o1)));
        for (int x : nums) queue.offer((long) x);
        long score = 0;
        while (k-- > 0) {
            Long x = queue.poll();
            score += x;
            queue.offer((long) Math.ceil(x / 3.0));
        }
        return score;
    }

    public static void main(String[] args) {
        int[] nums = {1, 10, 3, 3, 3};
        int k = 3;
//        System.out.println(Math.ceil(10.0 / 3.0));
        System.out.println(maxKelements2(nums, k));
    }
}
