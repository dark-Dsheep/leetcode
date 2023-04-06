package Skill;

import java.util.Arrays;
import java.util.HashMap;

public class MinSwaps {

    // 计算将数组排序的最小交换次数
    // 最少交换次数 = 节点数n - 形成的环数

    private static int getMinSwaps(int[] nums) {
        var nums1 = nums.clone();
        Arrays.sort(nums1);
        var map = new HashMap<Integer, Integer>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.put(nums1[i], i); // 建立每个元素与其应放位置的映射
        }
        int r = 0;
        var vis = new boolean[n];
        // 找出交换环的个数
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                int j = i;
                while (!vis[j]) {
                    vis[j] = true;
                    j = map.get(nums[j]); // 原序列中j的位置在有序序列中的位置
                }
                r++;
            }
        }
        return n - r;
    }


    public static void main(String[] args) {
        int[] arr = {7, 6, 8, 5};
        System.out.println(getMinSwaps(arr));
        swap(arr, 0, 1);
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int[] arr, int i, int j) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    static void solve(int[][] mat, int x1, int y1, int x2, int y2) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] s = new int[m+10][n+10];
        // 构建前缀和数组
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = i + 1, y = j + 1;
                s[x][y] = mat[i][j];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                s[i][j] += s[i-1][j] + s[i][j-1] - s[i-1][j-1];
            }
        }
        System.out.println(sumRange(s, x1, y1, x2, y2));

    }
    // (x1, y1)是左上角 (x2,y2)是右下角
    static int sumRange(int[][] s, int x1, int y1, int x2, int y2) {
        return s[x2+1][y2+1] - s[x1][y2+1] - s[x2+1][y1] + s[x1][y1];
    }
}
