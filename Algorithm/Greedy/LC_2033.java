package Algorithm.Greedy;

import java.util.ArrayList;

public class LC_2033 {

//    2033. 获取单值网格的最小操作数

    public int minOperations(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        var list = new ArrayList<Integer>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                list.add(grid[i][j]);
            }
        }
        list.sort((o1, o2) -> o1 - o2);

        int mid = list.get((list.size() - 1) / 2);
        int ans = 0;
        // 中位数贪心 => 类似题目 LC462. 最小操作次数使数组元素相等 II
        for (int x : list) {
            int abs = Math.abs(x - mid);
            if (abs % k != 0) return -1; // 不能被中位数整除 -> 无法减少或者增加到中位数
            ans += abs / k;             // 计算将当前数字转换到中位数 需要几次操作
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
