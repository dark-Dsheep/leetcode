package HardEX;

public class LC_1955 {

//    1955. 统计特殊子序列的数目 Rating(2125)

    int mod = 1000000007;
    int[][] f = new int[100001][3];
    int[] a = new int[100001];

    public int countSpecialSubsequences(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            a[i+1] = nums[i];
        }
        for (int i = 1; i <= n; i++) {
            if (a[i] == 0) {
                f[i][0] = (2 * f[i-1][0] + 1) % mod;
            } else if (a[i] == 1) {
                f[i][1] = (2 * f[i-1][1] + f[i-1][0]) % mod;
            } else {
                f[i][2] = (2 * f[i-1][2] + f[i-1][1]) % mod;
            }
        }
        return f[n][2];
    }


    public static void main(String[] args) {

    }
}
