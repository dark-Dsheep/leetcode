package DataStructure.Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC_1338 {

    /*
        LC1338. 数组大小减半
     */

    public int minSetSize(int[] arr) {
        var res = 0;
        var half = arr.length / 2;
        var cnt = arr.length;
        var map = new HashMap<Integer, Integer>();
        for (var x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        var pq = new PriorityQueue<Map.Entry<Integer, Integer>>(((o1, o2) -> o2.getValue() - o1.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }
        while (!pq.isEmpty()) {
            if (cnt <= half) break;
            cnt -= pq.poll().getValue();
            res++;
        }
        return res;
    }

    public static void main(String[] args) {

        var arr = new int[]{3,3,3,3,5,5,5,2,2,7};
        System.out.println(new LC_1338().minSetSize(arr));
    }
}
