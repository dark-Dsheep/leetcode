package Algorithm.BinarySearch;

import java.util.Arrays;

public class LC_2064 {

    /*
        2064. 分配给商店的最多商品的最小值
     */
    public int minimizedMaximum(int n, int[] quantities) {
        // 二分答案 -> 分配数目
        // 定义上下界
        int l = 1;
        int r = Arrays.stream(quantities).max().getAsInt();
        while (l < r) {
            int mid = l + (r - l) / 2;  // 模板1 -> 求最大值最小
            if (check(quantities, mid, n)) {
                r = mid;                // 无法给n个商店分配 减小mid
            } else {
                l = mid + 1;            // 可以给n个商店分配 增大mid
            }
        }
        return l;
    }

    // 判断n个商店能否每个分mid个商品
    private boolean check(int[] quantities, int mid, int n) {
        int cnt = 0; // 记录可以分配的商店数量
        for (int x : quantities) {
            cnt += (x + mid - 1) / mid;
        }
        return cnt <= n;
    }

    public static void main(String[] args) {
        int n = 7;
        int[] quantities = {15, 10, 10};
        System.out.println(new LC_2064().minimizedMaximum(n, quantities));
    }
}
