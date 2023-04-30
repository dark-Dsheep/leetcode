package Competition.biweekly.bw103;

import java.util.Arrays;

public class T1 {


    public int maximizeSum(int[] nums, int k) {
        // 最大值+1还是最大值 => 反复利用最大值
        int max = Arrays.stream(nums).max().getAsInt();
        int ans = 0;
        while (k-- > 0) {
            ans += max++;
        }
        return ans;
    }
}
