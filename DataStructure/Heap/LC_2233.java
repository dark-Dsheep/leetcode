package DataStructure.Heap;

import java.util.PriorityQueue;

public class LC_2233 {


    /*
        2233. K 次增加后的最大乘积
     */
    int mod = (int) 1e9 + 7;

    public int maximumProduct(int[] nums, int k) {
        // 小顶堆
        var pq = new PriorityQueue<Integer>(((o1, o2) -> o1 - o2));
        for (var x : nums) pq.offer(x);
        while (k-- > 0) {
            var num = pq.poll();
            num += 1;
            pq.offer(num);
        }
        var res = 1L;
        while (!pq.isEmpty()) res = (res * pq.poll()) % mod;
        return (int) res;
    }

    public static void main(String[] args) {

    }
}
