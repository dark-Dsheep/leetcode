package HardEX;


import java.util.Arrays;
import java.util.PriorityQueue;

public class LC_1383 {


//    1383. 最大的团队表现值 Rating(2091)

    int mod = 1000000007;

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = speed[i];
            a[i][1] = efficiency[i];
        }
        Arrays.sort(a, (x, y) -> y[1] - x[1]);
        var pq = new PriorityQueue<Integer>();
        long ans = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            if (pq.size() > k - 1) {
                sum -= pq.poll();
            }
            ans = Math.max(ans, (sum + a[i][0]) * a[i][1]);
            pq.offer(a[i][0]);
            sum += a[i][0];
        }
        return (int) (ans % mod);
    }



    public static void main(String[] args) {
        int n = 6;
        int[] speed = {2, 10, 3, 1, 5, 8};
        int[] efficiency = {5, 4, 3, 9, 7, 2};
        int k = 2;
        System.out.println(new LC_1383().maxPerformance(n, speed, efficiency, k));
    }
}
