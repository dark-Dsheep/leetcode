package DataStructure.Heap;

import java.util.Arrays;

public class LC_1887 {

    /*
        1887. 使数组元素相等的减少操作次数
        TODO
     */

    public int reductionOperations(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        Arrays.sort(nums);
        int largest = nums[n - 1];

        return 0;
    }


    public static void main(String[] args) {
        int[] nums = {5, 1, 3};
        System.out.println(new LC_1887().reductionOperations(nums));
    }
}
