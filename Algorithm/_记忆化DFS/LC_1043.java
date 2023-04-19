package Algorithm._记忆化DFS;

import java.util.Arrays;

public class LC_1043 {

//    1043. 分隔数组以得到最大和

    int[] f = new int[510];
    int k;
    int[] arr;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        this.arr = arr;
        this.k = k;
        Arrays.fill(f, -1);
        return dfs(arr.length - 1);
    }

    int dfs(int i) {
        if (i < 0) return 0;
        if (f[i] != -1) return f[i];
        int ans = 0;
        for (int j = i, mx = 0; i - j + 1 <= k && j >= 0; j--) {
            mx = Math.max(mx, arr[j]);
            ans = Math.max(ans, dfs(j - 1) + mx * (i - j + 1));
        }
        return f[i] = ans;
    }

    public static void main(String[] args) {

    }
}
