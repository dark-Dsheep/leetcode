package Competition.weekly.wr331;

import java.util.PriorityQueue;

public class T1 {


    public long pickGifts(int[] gifts, int k) {
        var pq = new PriorityQueue<Integer>(((o1, o2) -> o2 - o1));
        for (var x : gifts) pq.offer(x);
        while (k-- > 0 && !pq.isEmpty()) {
            int x = pq.poll();
            pq.offer((int) Math.sqrt(x));
        }
        long res = 0;
        while (!pq.isEmpty()) res += pq.poll();
        return res;
    }
    public static void main(String[] args) {
        var gif = new int[] {25, 64, 9, 4, 100};
        int k = 4;
        System.out.println(new T1().pickGifts(gif, k));
    }
}
