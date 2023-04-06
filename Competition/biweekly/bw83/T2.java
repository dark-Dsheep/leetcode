package Competition.biweekly.bw83;

public class T2 {

    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int cnt = 0;
        for (int x : nums) {
            if (x != 0) {
                cnt = 0;
            } else {
                cnt += 1;
                ans += cnt;
            }
        }
        return ans;
    }
}
