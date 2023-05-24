package Algorithm.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LC_1654 {

    HashSet<Integer> set = new HashSet<>();


    /*
        1654. 到家的最少跳跃次数
     */

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        for (int f : forbidden) set.add(f);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 0));
        while (!queue.isEmpty()) {
            Node p = queue.poll();
            if (p.point == x) {
                return p.step;
            }
            int np1 = p.point + a; // 下一个右点
            int np2 = p.point - b; // 下一个左点
            if (!set.contains(np1) && np1 <= 7000) {
                set.add(np1);
                queue.offer(new Node(np1, p.step + 1, 0));
            }
            // 上一个方向不是左 并且不为负点
            if (p.dir == 0 && np2 >= 0) {
                if (!set.contains(np2)) {
                    queue.offer(new Node(np2, p.step + 1, 1));
                }
            }
        }
        return -1;
    }

    class Node {
        int point;
        int step;
        int dir; // 0-右 1-左

        public Node(int point, int step, int dir) {
            this.point = point;
            this.step = step;
            this.dir = dir;
        }
    }


    public static void main(String[] args) {

    }
}
