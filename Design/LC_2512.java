package Design;

import java.util.*;

public class LC_2512 {

//    2512. 奖励最顶尖的 K 名学生

    HashSet<String> good = new HashSet<>();
    HashSet<String> bad = new HashSet<>();
    HashMap<Integer, Node> map = new HashMap<>();   // id 学生
    PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.compareTo(o2));

    public List<Integer> topStudents(String[] pf, String[] nf, String[] reps, int[] ids, int k) {
        for (var s : pf) good.add(s);
        for (var s : nf) bad.add(s);

        for (int i = 0; i < ids.length; i++) {
            int id = ids[i];
            int val = 0;
            for (var r : reps[i].split(" ")) {
                if (good.contains(r)) val += 3; // 累加得分
                else if (bad.contains(r)) val -= 1;
            }
            var newNode = new Node(id, val);
            if (map.containsKey(id)) {
                var oldNode = map.get(id);
                oldNode.delete = true;
                newNode.score += oldNode.score;
            }
            map.put(id, newNode);
            pq.offer(newNode);
        }
        process(pq);
        var ans = new ArrayList<Integer>();
        while (k-- > 0 && pq.size() > 0) {
            ans.add(pq.poll().id);
        }
        return ans;
    }

    // 处理标记为删除的旧数据
    void process(PriorityQueue<Node> pq) {
        while (pq.size() > 0 && pq.peek().delete) {
            pq.poll();
        }
    }

    class Node implements Comparable<Node> {
        int id;
        int score;
        boolean delete;

        public Node(int id, int score) {
            this.id = id;
            this.score = score;
            this.delete = false;
        }

        @Override
        public int compareTo(Node o) {
            return this.score == o.score ? this.id - o.id : o.score - this.score;
        }
    }


    public static void main(String[] args) {

    }
}
