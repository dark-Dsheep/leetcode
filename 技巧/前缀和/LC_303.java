package 技巧.前缀和;

public class LC_303 {

    /*
        303. 区域和检索 - 数组不可变
     */
    // 一维前缀和
    class NumArray {
        int[] g;

        public NumArray(int[] nums) {
            g = new int[nums.length];
            g[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                g[i] = g[i - 1] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            if (left == 0) return g[right];
            // S3 - S5的和 -> g[5] - g[3 - 1] 的差
            return g[right] - g[left - 1];
        }
    }


    public static void main(String[] args) {

        var s = "aaa";
        
    }
}
