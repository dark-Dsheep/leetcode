package DataStructure.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC_2406 {

    /*
        LC-2406.将区间分为最少组数
     */
    public int minGroups(int[][] intervals) {
        // 类似题目: LC-253
        // 对区间左端点升序排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        // 小顶堆 存储区间的右端点
        var pq = new PriorityQueue<Integer>((o1, o2) -> o1 - o2);
        // 划分不相交的区间
        pq.offer(intervals[0][1]);
        for (var i = 1; i < intervals.length; i++) {
            var cur = intervals[i]; // 当前区间
            // 如果堆顶的右端点跟当前区间的左端点不相交
            if (pq.peek() < cur[0]) {
                pq.poll();
                pq.offer(cur[1]);   // 合并一组 更新堆顶右端点
            } else {
                pq.offer(cur[1]);
            }
        }
        return pq.size();
    }

    public static void main(String[] args) {
        var intervals = new int[][]{{5, 10}, {6, 8}, {1, 5}, {2, 3}, {1, 10}};
        System.out.println(new LC_2406().minGroups(intervals));
    }
}
