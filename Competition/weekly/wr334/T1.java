package Competition.weekly.wr334;

public class T1 {


    public int[] leftRigthDifference(int[] nums) {
        int n = nums.length;
        var ls = new int[n];
        var rs = new int[n];
        for (int i = 1; i < n; i++) ls[i] = ls[i - 1] + nums[i - 1];
        for (int i = n - 2; i >= 0; i--) rs[i] = rs[i + 1] + nums[i + 1];
        for (int i = 0; i < n; i++) {
            nums[i] = Math.abs(rs[i] - ls[i]);
        }
        return nums;
    }

    public static void main(String[] args) {

    }
}
