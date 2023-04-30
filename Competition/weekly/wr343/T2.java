package Competition.weekly.wr343;

import java.util.HashMap;

public class T2 {


    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        var row = new HashMap<Integer, Integer>();
        var col = new HashMap<Integer, Integer>();
        var map = new HashMap<Integer, int[]>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }
        for (int i = 0; i < arr.length; i++) {
            var p = map.get(arr[i]);
            row.merge(p[0], 1, Integer::sum);
            col.merge(p[1], 1, Integer::sum);
            if (row.get(p[0]) == n || col.get(p[1]) == m) {
                return i;
            }
        }
        return -1;
    }
}
