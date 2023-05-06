package 技巧.双指针;

import java.util.ArrayList;
import java.util.List;

public class LC_986 {

//    986. 区间列表的交集
    List<int[]> list = new ArrayList<>();

    public int[][] intervalIntersection(int[][] f, int[][] s) {
        int m = f.length, n = s.length;
        if (m == 0 || n == 0) return new int[0][0];
        int i = 0, j = 0;
        while (i < m && j < n) {
            // 求交集
            int start = Math.max(f[i][0], s[j][0]);
            int end = Math.min(f[i][1], s[j][1]);
            if (start <= end) list.add(new int[]{start, end});
            // System.out.println("start => " + start);
            // System.out.println("end => " + end);
            // 让右边界小区间延伸
            if (f[i][1] < s[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        int[][] ans = new int[list.size()][2];
        for (i = 0; i < ans.length; i++) ans[i] = list.get(i);
        return ans;
    }

}
