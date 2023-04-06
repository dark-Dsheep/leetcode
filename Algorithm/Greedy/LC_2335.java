package Algorithm.Greedy;


import java.util.PriorityQueue;

public class LC_2335 {
    /*
        2335. 装满杯子需要的最短总时长
     */
    public int fillCups(int[] amount) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(amount.length, ((o1, o2) -> o2 - o1));
        int sum = 0;
        for (int a : amount) {
            if (a != 0) {
                queue.offer(a);
            }
            sum += a;
        }
        int res = 0;
        while (!queue.isEmpty()) {
            if (sum <= 0) break;
            if (queue.size() > 1) {
                // 两个类型接2杯
                int v1 = queue.poll();
                int v2 = queue.poll();
                v1--; v2--;
                if (v1 != 0) {
                    queue.offer(v1);
                }
                if (v2 != 0) {
                    queue.offer(v2);
                }
                sum -= 2;
                res += 1;
            } else {
                // 一个类型接2杯
                int v = queue.poll();
                v--;
                if (v != 0) {
                    queue.offer(v);
                }
                sum -= 1;
                res += 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] amount = {0, 2, 2};
        System.out.println(new LC_2335().fillCups(amount));
    }
}
