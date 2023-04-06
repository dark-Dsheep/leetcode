package Skill.DoublePointer;

import java.util.Arrays;

public class LC_1679 {

    /*
        1679. K 和数对的最大数目
     */
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int cnt = 0;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == k) {
                cnt += 1;
                i++;
                j--;
            } else if (sum < k) {
                i++;
            } else {
                j--;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {

    }
}
