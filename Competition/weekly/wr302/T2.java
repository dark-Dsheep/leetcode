package Competition.weekly.wr302;

import java.util.HashMap;
import java.util.PriorityQueue;

public class T2 {

    public int maximumSum(int[] nums) {
        var map = new HashMap<Integer, PriorityQueue<Integer>>();
        for (int x : nums) {
            int sum = cal(x);
            map.computeIfAbsent(sum, v -> new PriorityQueue<>((o1, o2) -> o2-o1));
            map.get(sum).add(x);
        }
        int ans = -1;
        for (var e : map.entrySet()) {
            var pq = e.getValue();
            if (pq.size() > 1) {
                int a = pq.poll();
                int b = pq.poll();
                ans = Math.max(ans, a+b);
            }
        }
        return ans;
    }

    int cal(int x) {
        int sum = 0;
        while (x != 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
