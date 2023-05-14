package Competition.biweekly.bw104;

import java.util.Arrays;

public class T2 {

    public int matrixSum(int[][] nums) {
        for (var row : nums) {
            Arrays.sort(row);
        }
        int ans = 0;
        int m = nums.length;
        int n = nums[0].length;
        for (int j = 0; j < n; j++) {
            int mx = 0;
            for (int i = 0; i < m; i++) {
                mx = Math.max(mx, nums[i][j]);
            }
            ans += mx;
        }
        return ans;
    }



    public static void main(String[] args) {

    }
}
