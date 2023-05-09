package 困难题训练;

import java.util.HashMap;
import java.util.HashSet;

public class LC_1001 {


//    1001. 网格照明 Rating(1873)

    int[][] dirs = new int[][]{{0,0},{0,-1},{0,1},{-1,0},{-1,-1},{-1,1},{1,0},{1,-1},{1,1}};

    // 哈希表 + 线映射模拟
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        long N = n;
        var row = new HashMap<Integer, Integer>();
        var col = new HashMap<Integer, Integer>();
        var left = new HashMap<Integer, Integer>(); // 左对角线
        var right = new HashMap<Integer, Integer>(); // 右对角线
        var set = new HashSet<Long>();              // 记录灯的位置
        for (var l : lamps) {
            int x = l[0], y = l[1];
            int a = x + y, b = x - y; // 左右对角线 使用截距
            if (set.contains(x * N + y)) continue;
            row.merge(x, 1, Integer::sum); col.merge(y, 1, Integer::sum);
            left.merge(a, 1, Integer::sum); right.merge(b, 1, Integer::sum);
            set.add(x * N + y);
        }
        var ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            var q = queries[i];
            int x = q[0], y = q[1];
            int a = x + y, b = x - y;
            if (row.containsKey(x) || col.containsKey(y) || left.containsKey(a) || right.containsKey(b)) {
                ans[i] = 1;
            }
            for (var d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                int na = nx + ny, nb = nx - ny;
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (set.contains(nx * N + ny)) {    // 灭灯
                    set.remove(nx * N + ny);
                    close(row, nx); close(col, ny);
                    close(left, na); close(right, nb);
                }
            }
        }
        return ans;
    }

    void close(HashMap<Integer, Integer> map, int key) {
        if (map.get(key) == 1) {
            map.remove(key);
        } else {
            map.merge(key, -1, Integer::sum);
        }
    }


    public static void main(String[] args) {

    }
}
