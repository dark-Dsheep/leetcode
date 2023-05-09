package 困难题训练;

public class LC_1458 {

//    1458. 两个子序列的最大点积 Rating(1824)

    Integer[][] memo = new Integer[501][501];
    int[] a;
    int[] b;

    public int maxDotProduct(int[] nums1, int[] nums2) {
        a = nums1;
        b = nums2;
        return dfs(0, 0);
    }

    int dfs(int i, int j) {
        if (i >= a.length || j >= b.length) {
            return -0x3f3f3f;
        }
        if (memo[i][j] != null) return memo[i][j];
        // 5种选取方案
        int ans = a[i] * b[j]; // 不选前面的
        int c1 = a[i] * b[j] + dfs(i+1, j+1); // i,j都选
        int c2 = dfs(i+1, j+1); // 不选当前的i,j
        int c3 = dfs(i+1, j);   // 选i不选j
        int c4 = dfs(i, j+1);   // 选j不选i
        ans = Math.max(ans, Math.max(Math.max(c1, c2), Math.max(c3, c4)));
        return memo[i][j] = ans;
    }


    public static void main(String[] args) {

    }
}
