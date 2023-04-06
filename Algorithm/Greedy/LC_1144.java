package Algorithm.Greedy;

public class LC_1144 {

//    1144. 递减元素使数组呈锯齿状
    public int movesToMakeZigzag(int[] nums) {
        int n = nums.length;
        int cnt1 = 0;
        int cnt2 = 0;
        // case 1
        for (int i = 0, j = 2; i < n - 1; i += 2, j += 2) {
            if (j < n) {
                int evenMin = Math.min(nums[i], nums[j]);
                if (evenMin <= nums[i + 1]) cnt1 += nums[i + 1] - evenMin + 1;
            } else {
                if (nums[i] <= nums[i + 1]) cnt1 += nums[i + 1] - nums[i] + 1;
            }
        }
        // case 2
        for (int i = 1, j = 3; i < n - 1; i += 2, j += 2) {
            if (i == 1) cnt2 += nums[i - 1] >= nums[i] ? nums[i - 1] - nums[i] + 1 : 0;
            if (i == n - 2) cnt2 += nums[i + 1] >= nums[i] ? nums[i + 1] - nums[i] + 1 : 0;
            if (j < n) {
                int oddMin = Math.min(nums[i], nums[j]);
                if (oddMin <= nums[i + 1]) cnt2 += nums[i + 1] - oddMin + 1;
            }
        }
        return Math.min(cnt1, cnt2);
    }

    public static void main(String[] args) {
        int[] nums = {9, 6, 1, 6, 2};
        System.out.println(new LC_1144().movesToMakeZigzag(nums));
    }
}
