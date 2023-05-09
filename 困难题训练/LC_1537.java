package 困难题训练;

import java.util.HashMap;

public class LC_1537 {

//    1537. 最大得分 Rating(1961)

    int mod = 1000000007;
    Long[][] f = new Long[2][100001];
    int[][] vv;
    HashMap<Integer, Integer> a;
    HashMap<Integer, Integer> b;

    public int maxSum(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        vv = new int[][]{nums1, nums2};
        a = new HashMap<>(m);
        b = new HashMap<>(n);
        for (int i = 0; i < m; i++) {
            a.put(nums1[i], i);
        }
        for (int i = 0; i < n; i++) {
            b.put(nums2[i], i);
        }
        return (int) (Math.max(dfs(0, 0), dfs(1, 0)) % mod);
    }


    long dfs(int pos, int i) {
        var arr = vv[pos];
        if (i >= arr.length) return 0;
        if (f[pos][i] != null) return f[pos][i];
        long ans = 0;
        ans = Math.max(ans, arr[i] + dfs(pos, i+1));
        if (pos == 0 && b.containsKey(arr[i])) {
            ans = Math.max(ans, arr[i] + dfs(1, b.get(arr[i])+1));
            ans %= mod;
        } else if (pos == 1 && a.containsKey(arr[i])) {
            ans = Math.max(ans, arr[i] + dfs(0, a.get(arr[i])+1));
            ans %= mod;
        }
        return f[pos][i] = ans;
    }

    public static void main(String[] args) {

    }


}
