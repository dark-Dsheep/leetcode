package Algorithm.Greedy;


import java.util.Arrays;

public class LC_1509 {

//    1509. 三次操作后最大值与最小值的最小差

    public int minDifference(int[] nums) {
        if (nums.length <= 4) return 0;
        Arrays.sort(nums);
        int n = nums.length;
        int ans1 = Math.abs(nums[n - 1] - nums[0]);
        int ans2 = Math.abs(nums[n - 2] - nums[1]);
        int ans3 = Math.abs(nums[n - 3] - nums[2]);
        int ans4 = Math.abs(nums[n - 4] - nums[3]);
        return Math.min(Math.min(ans1, ans2), Math.min(ans3, ans4));
    }

    public static void main(String[] args) {
        int[] nums = {1,5,0,10,14};
        System.out.println(new LC_1509().minDifference(nums));
    }
}
