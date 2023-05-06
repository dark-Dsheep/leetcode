package 技巧.双指针;

public class LC_2106 {

    /**
     * 2106. 摘水果
     */
    int[] f = new int[200001];

    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        for (var v : fruits) {
            f[v[0]] += v[1];
        }
        for (int i = 1; i <= 200000; i++) {
            f[i] += f[i - 1];
        }
        int ans = 0;
        // 两种走法: 1.往右走x, 折返往左走y 2.往左走x, 折返往右走y
        // 两种走法都走了, 2 * x + y步 => k = 2 * x + y 推出 y = k - 2 * x
        // 枚举x
        for (int x = 0; 2 * x <= k; x++) {
            int y = k - 2 * x;
            int l1 = Math.max(startPos - x, 0);
            int r1 = Math.min(startPos + y, 200000);
            int l2 = Math.max(startPos - y, 0);
            int r2 = Math.min(startPos + x, 200000);
            ans = Math.max(ans, Math.max(
                    f[r1] - (l1 > 0 ? f[l1 - 1] : 0),
                    f[r2] - (l2 > 0 ? f[l2 - 1] : 0)));
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
