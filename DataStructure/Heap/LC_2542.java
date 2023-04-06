package DataStructure.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC_2542 {

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long[][] a = new long[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = nums1[i];
            a[i][1] = nums2[i];
        }
        Arrays.sort(a, (x, y) -> Long.compare(y[1], x[1]));
        var pq = new PriorityQueue<Long>();
        long ans = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            pq.offer(a[i][0]);
            sum += a[i][0];
            if (pq.size() > k) {
                sum -= pq.poll();
            }
            if (pq.size() == k) {
                ans = Math.max(ans, sum  * a[i][1]);
            }

        }
        return ans;
    }
}
