package 困难题训练;


import java.util.Arrays;
import java.util.TreeSet;

public class LC_1847 {

//    1847. 最近的房间 Rating(2082)
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        // 将查询离线处理 按照minSize从大到小
        int n = queries.length;
        var q = new int[n][3];
        for (int i = 0; i < n; i++) {
            q[i][0] = queries[i][0];
            q[i][1] = queries[i][1];
            q[i][2] = i;
        }
        Arrays.sort(q, (a, b) -> b[1] - a[1]);
        Arrays.sort(rooms, (a, b) -> b[1] - a[1]);
        var tset = new TreeSet<Integer>();
        var ans = new int[n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            // 将房间面积至少为q[i][1]的 房间号加入tset
            while (idx < rooms.length && rooms[idx][1] >= q[i][1]) {
                tset.add(rooms[idx][0]);
                idx++;
            }
            // 拿到两个最近的房间号
            Integer a = tset.floor(q[i][0]);
            Integer b = tset.ceiling(q[i][0]);
            if (a == null && b == null) {
                ans[q[i][2]] = -1;
            } else if (a == null || b == null) {
                ans[q[i][2]] = a == null ? b : a;
            } else {
                int x = Math.abs(a - q[i][0]);
                int y = Math.abs(b - q[i][0]);
                ans[q[i][2]] = x > y ? b : a;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
