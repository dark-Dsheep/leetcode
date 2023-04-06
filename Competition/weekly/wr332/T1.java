package Competition.weekly.wr332;

public class T1 {




    public long findTheArrayConcVal(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        long ans = 0;
        while (i <= j) {
            if (i == j) {
                ans += nums[i];
            } else {
                ans += Long.parseLong("" + nums[i] + nums[j]);
            }
            i++;
            j--;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
