package DataStructure.Heap;

import java.util.PriorityQueue;

public class LC_2182 {

    /*
        2182. 构造限制重复的字符串
     */
    public String repeatLimitedString(String s, int repeatLimit) {
        var count = new int[26];
        for (var c : s.toCharArray()) {
            count[c - 'a']++;
        }
        var pq = new PriorityQueue<Node>((a, b) -> b.data - a.data);
        for (var i = 0; i < 26; i++) {
            if (count[i] != 0) {
                var data = (char) (i + 'a');
                pq.offer(new Node(data, count[i]));
            }
        }
        var sb = new StringBuilder();
        var preChar = '#';
        var preCnt = 0;
        while (!pq.isEmpty()) {
            var p0 = pq.poll();
            if (preChar != p0.data) {
                sb.append(p0.data);
                p0.cnt--;
                if (p0.cnt != 0) pq.offer(p0);
                preChar = p0.data;
                preCnt = 1;
            } else if (++preCnt <= repeatLimit) { // 可重复放
                sb.append(p0.data);
                p0.cnt--;
                if (p0.cnt != 0) pq.offer(p0);
            } else {                           // 超出重复放置次数 选择字典序第二大
                if (pq.isEmpty()) break;
                var p1 = pq.poll();
                sb.append(p1.data);
                p1.cnt--;
                if (p1.cnt != 0) pq.offer(p1);
                pq.offer(p0);
                preChar = p1.data;
                preCnt = 1;
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

    public static void main(String[] args) {
         var s = "cczazcc";
         var limit = 3;
        System.out.println(new LC_2182().repeatLimitedString(s, limit));
    }
}
