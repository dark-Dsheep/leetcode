package Algorithm.BinarySearch;

public class LC_33 {

//    33. 搜索旋转排序数组
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) return nums[0] == target ? 0 : -1;
        // 第一次二分找到分割点
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] >= nums[0]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        if (target >= nums[0]) {
            l = 0;
        } else {
            l = l + 1;
            r = n - 1;
        }
        // 第二次二分找target
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[r] == target ? r : -1;
    }

    public static void main(String[] args) {

    }
}
