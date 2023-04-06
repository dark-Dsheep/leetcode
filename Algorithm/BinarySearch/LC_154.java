package Algorithm.BinarySearch;

public class LC_154 {


//    154. 寻找旋转排序数组中的最小值 II

    public int findMin(int[] nums) {
        int n = nums.length - 1;
        // 去除跟nums[0]元素相同的后缀
        while (n > 0 && nums[n] == nums[0]) n--;
        if (nums[n] > nums[0]) return nums[0]; // 已经单调递增
        int l = 0, r = n;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] < nums[0]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {

    }
}
