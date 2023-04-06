package Algorithm.Dp;

public class LC_1749 {

    public int maxAbsoluteSum(int[] nums) {
        int preSum = 0, max = 0, min = 0;
        // 有正数负数的数组，子数组最大绝对值 = 最大前缀 - 最小前缀和
        // 只有正数        子数组最大绝对值 = 最大前缀
        // 只有负数        子数组最大绝对值 = 最小前缀和
        for (int x : nums) {
            preSum += x;
            if (max < preSum) {
                max = preSum;
            }
            if (min > preSum) {
                min = preSum;
            }
        }
        return max - min;
    }


    public static void main(String[] args) {
        System.out.println(new LC_1749().maxAbsoluteSum(new int[]{2,-5,1,-4,3,-2}));
    }
}
