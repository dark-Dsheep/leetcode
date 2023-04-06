package DataStructure.Heap;

import java.util.PriorityQueue;

public class LC_1405 {

    /*
        1405. 最长快乐字符串
     */

    public String longestDiverseString(int a, int b, int c) {
        var aNode = new Node('a', a);
        var bNode = new Node('b', b);
        var cNode = new Node('c', c);
        var pq = new PriorityQueue<Node>(((o1, o2) -> o2.cnt - o1.cnt));
        pq.offer(aNode);
        pq.offer(bNode);
        pq.offer(cNode);
        StringBuilder sb = new StringBuilder();
        int preCnt = 0;
        char preChar = '.';
        while (!pq.isEmpty()) {
            Node p0 = pq.poll();
            if (p0.data != preChar) {
                sb.append(p0.data);
                preChar = p0.data;
                preCnt = 1;
                p0.setCnt(p0.cnt - 1);
                if (p0.cnt > 1) pq.offer(p0);
            } else if (preCnt < 2) {
                sb.append(p0.data);
                preCnt = 2;
                p0.setCnt(p0.cnt - 1);
                if (p0.cnt > 1) pq.offer(p0);
            } else {                    // 前一个字符使用了两次 选择次数第二多的字符拼接
                if (pq.isEmpty()) break;
                Node p1 = pq.poll();
                sb.append(p1.data);
                preChar = p1.data;
                preCnt = 1;
                p1.setCnt(p1.cnt - 1);
                if (p1.cnt > 1) pq.offer(p1);
                pq.offer(p0);
            }
        }
        System.out.println(sb);
        return "";
    }

    class Node {
        char data;
        int cnt;

        public Node(char data, int cnt) {
            this.data = data;
            this.cnt = cnt;
        }

        public void setCnt(int cnt) {
            this.cnt = cnt;
        }
    }


    public static void main(String[] args) {
        System.out.println(new LC_1405().longestDiverseString(1, 1, 7));
    }
}
