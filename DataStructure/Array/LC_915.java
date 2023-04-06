package DataStructure.Array;

public class LC_915 {

    /*
        915. 分割数组
     */
    public int partitionDisjoint(int[] nums) {
        if (nums.length == 0) return 0;
        int leftMax = nums[0];
        int curMax = nums[0];
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(curMax, nums[i]);
            // 当前元素 < 左边数组的最大值，划分区间
            if (nums[i] < leftMax) {
                // 更新左边最大值
                leftMax = curMax;
                index = i;
            }
        }
        return index + 1;
    }

    public static void main(String[] args) {

    }
}
