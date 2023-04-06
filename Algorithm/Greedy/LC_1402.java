package Algorithm.Greedy;

import java.util.Arrays;

public class LC_1402 {

//    1402. 做菜顺序

    public int maxSatisfaction(int[] nums) {
        // 贪心：越往后乘积越大,将nums中大的数放在后面
        Arrays.sort(nums);
        int ans = 0, val = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            val += nums[i];
            if (val <= 0) break;
            ans += val;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] s = {2, -2, -3, 1};
        System.out.println(new LC_1402().maxSatisfaction(s));
    }
}
