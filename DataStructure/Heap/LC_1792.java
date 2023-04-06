package DataStructure.Heap;

import java.util.PriorityQueue;

public class LC_1792 {

    /*
        1792. 最大平均通过率
     */
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // 错误贪心思路 将额外的学生分配给通过率低的班级
        // 正确贪心思路 将分子分母都+1 减去原来的通过率,计算通过增率,最大的排上面
        var pq = new PriorityQueue<int[]>((a, b) -> {
            return Double.compare(
                    (b[0] + 1.0) / (b[1] + 1.0) - b[0] / (double) b[1],
                    (a[0] + 1.0) / (a[1] + 1.0) - a[0] / (double) a[1]);
        });
        for (int[] c : classes) pq.offer(c);
        while (extraStudents-- > 0) {
            var p = pq.poll();
            p[0]++; p[1]++;
            pq.offer(p);
        }
        double sum = 0;
        while (!pq.isEmpty()) {
            var p = pq.poll();
            sum += p[0] / (double) p[1];
        }
        return sum / classes.length;
    }

    public static void main(String[] args) {
        var classes = new int[][] {{1, 2}, {3, 5}, {2, 2}};
        System.out.println(3.0 / 5.0);
        System.out.println(new LC_1792().maxAverageRatio(classes, 2));
    }
}
