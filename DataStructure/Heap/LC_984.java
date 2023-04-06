package DataStructure.Heap;

import java.util.PriorityQueue;

public class LC_984 {

    public String strWithout3a3b(int a, int b) {

        var aNode = new Node('a', a);
        var bNode = new Node('b', b);
        var pq = new PriorityQueue<Node>(((o1, o2) -> o2.cnt - o1.cnt));
        pq.offer(aNode);
        pq.offer(bNode);
        var sb = new StringBuilder();
        var preChar = '#';
        int preCnt = 0;

        while (!pq.isEmpty()) {
            var p0 = pq.poll();
            if (preChar != p0.data) {
                sb.append(p0.data);
                p0.cnt--;
                if (p0.cnt != 0) pq.offer(p0);
                preChar = p0.data;
                preCnt = 1;
            } else if (preCnt < 2) {
                sb.append(p0.data);
                p0.cnt--;
                if (p0.cnt != 0) pq.offer(p0);
                preCnt = 2;
            } else {
                if (pq.isEmpty()) break;
                var p1 = pq.poll();
                sb.append(p1.data);
                p1.cnt--;
                if (p1.cnt != 0) pq.offer(p1);
                pq.offer(p0);
                preChar = p1.data;
                preChar = 1;
            }
        }
        return sb.toString();
    }


    class Node {
        char data;
        int cnt;

        public Node(char data, int cnt) {
            this.data = data;
            this.cnt = cnt;
        }
    }
}
