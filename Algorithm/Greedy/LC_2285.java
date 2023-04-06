package Algorithm.Greedy;

import java.util.Arrays;

public class LC_2285 {

    /*
        LC-2285.道路的最大总重要性
     */

    public long maximumImportance(int n, int[][] roads) {
        var count = new long[n];
        for (int[] r : roads) {
            // 统计节点的入度
            count[r[0]]++;
            count[r[1]]++;
        }
        Arrays.sort(count);
        // 对于入度越多的节点越重要,给它更多的数值
        var res = 0L;
        for (var i = 0; i < n; i++) {
            res += count[i] * (i + 1);
        }
        return res;
    }


    public static void main(String[] args) {

    }
}
