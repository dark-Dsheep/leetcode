package Algorithm.Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC_253 {


    /*
       253. 会议室 II
     */

    // 双指针解法
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n], end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0]; // 记录上车时间
            end[i] = intervals[i][1];   // 记录下车时间
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int i = 0, j = 0;
        int count = 0; // 记录同时在车上的最大数
        int res = 0;
        while (i < n && j < n) {
            if (start[i] < end[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            res = Math.max(res, count);
        }
        return res;
    }

    // 优先队列解法
    public int minMeetingRooms2(int[][] intervals) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(intervals.length, (Comparator.comparingInt(o -> o)));
        Arrays.sort(intervals, (Comparator.comparingInt(o -> o[0])));
        queue.offer(intervals[0][1]); // 添加第一场会议的结束时间
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= queue.peek()) { //
                queue.poll();
            }
            queue.offer(intervals[i][1]);
        }
        return queue.size();
    }
    public static void main(String[] args) {
        int[][] intervals = {{5, 10}, {6, 8}, {1, 5}, {2, 3}, {1, 10}};
//        System.out.println(new LC_253().minMeetingRooms(intervals));
        System.out.println(new LC_253().minMeetingRooms2(intervals));
    }
}
