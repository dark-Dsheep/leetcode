package Competition.weekly.wr340;


public class T1 {

    public int diagonalPrime(int[][] nums) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (check(nums[i][i])) {
                ans = Math.max(ans, nums[i][i]);
            }
            if (check(nums[i][n-i-1])) {
                ans = Math.max(ans, nums[i][n-i-1]);
            }
        }
        return ans;
    }


    boolean check(int x) {
        if (x < 2) return false;
        for (int i = 2; i <= x / i; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
