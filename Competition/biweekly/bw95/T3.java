package Competition.biweekly.bw95;

import java.util.Arrays;

public class T3 {

    public static int xorBeauty(int[] nums) {
        Arrays.sort(nums);
        // 2 5 15 20 30 32 34 35 44 45
        int res = 0;
        for (int x : nums) res ^= x;

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                for (int k = 0; k < n; k++) {
//                    res ^= ((nums[i] | nums[j]) & nums[k]);
//                    count++;
//                }
//            }
//        }
        return res;
    }

    public static void main(String[] args) {

    }
}
