package DataStructure.Heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LC_1054 {

    /*
         1054. 距离相等的条形码
     */

    public int[] rearrangeBarcodes(int[] barcodes) {
        var map = new HashMap<Integer, Node>();
        for (var x : barcodes) {
            if (map.containsKey(x)) {
                var node = map.get(x);
                node.cnt++;
                map.put(x, node);
            } else {
                map.put(x, new Node(x, 1));
            }
        }
        var pq = new PriorityQueue<Node>((a, b) -> b.cnt - a.cnt);
        for (var node : map.values()) {
            pq.offer(node);
        }
        var res = new int[barcodes.length];
        var idx = 0;
        var preNum = -1;
        while (!pq.isEmpty() && idx < barcodes.length) {
            var p0 = pq.poll();
            if (p0.num != preNum) {
                res[idx] = p0.num;
                p0.cnt--;
                pq.offer(p0);
                preNum = p0.num;
            } else {
                if (pq.isEmpty()) break;
                // 选择数量第二多的数字
                var p1 = pq.poll();
                res[idx] = p1.num;
                p1.cnt--;
                pq.offer(p1);
                pq.offer(p0);
                preNum = p1.num;
            }
            idx++;
        }
        return res;
    }


    class Node {
        int num;
        int cnt;

        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {

        var barcodes = new int[] {1, 1, 1, 2, 2, 2};
        System.out.println(Arrays.toString(new LC_1054().rearrangeBarcodes(barcodes)));
    }
}
