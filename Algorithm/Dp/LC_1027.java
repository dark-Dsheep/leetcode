package Algorithm.Dp;

import java.util.Arrays;

public class LC_1027 {

//    1027. 最长等差数列

    int[][] f = new int[1010][1010];
    public int longestArithSeqLength(int[] nums) {
        // f[i][d]表示 以i结尾公差为d的最长等差数列长度
        for (var x : f) Arrays.fill(x, 1);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                int d = nums[i] - nums[j] + 500;
                f[i][d] = Math.max(f[i][d], f[j][d] + 1);
                ans = Math.max(ans, f[i][d]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
