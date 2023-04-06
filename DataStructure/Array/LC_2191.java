package DataStructure.Array;

import java.util.Arrays;

public class LC_2191 {

    // TODO
    public int[] sortJumbled(int[] mapping, int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int v = 0;
            while (x != 0) {
                v = v * 10 + mapping[x % 10];
                x = x / 10;
            }
            while (v != 0) {

            }
            System.out.println(v);
        }
        return nums;
    }


    public static void main(String[] args) {
        int[] mapping = {8, 9, 4, 0, 2, 1, 3, 5, 7, 6};
        int[] nums = {991, 338, 38};
        System.out.println(Arrays.toString(new LC_2191().sortJumbled(mapping, nums)));

    }
}
