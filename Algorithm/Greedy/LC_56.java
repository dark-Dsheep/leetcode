package Algorithm.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_56 {

    /*
        56. 合并区间
     */

    public int[][] merge(int[][] intervals) {

        // 将数组按照start从小到达排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; ) {
            int iStart = intervals[i][0]; // 第i个区间的开始时间
            int iEnd = intervals[i][1]; // 第i个区间的结束时间
            int j = i + 1;
            // 合并区间 -> j往后寻找一个区间 jStart <= iEnd 并且取一个最远的End
            while (j < intervals.length && intervals[j][0] <= iEnd) {
                iEnd = Math.max(iEnd, intervals[j][1]);
                j++;
            }
            list.add(List.of(iStart, iEnd));
            i = j; // i - j的区间已经合并 移动i到j 合并下一个区间
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            int start = list.get(i).get(0);
            int end = list.get(i).get(1);
            res[i] = new int[]{start, end};
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(new LC_56().merge(intervals)));

    }
}

