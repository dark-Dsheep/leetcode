package Algorithm.BinarySearch;

public class LC_34 {

//    34. 在排序数组中查找元素的第一个和最后一个位置

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int l = lower(nums, target);
        int r = higher(nums, target);
        return new int[]{l, r};
    }

    int lower(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (nums[l] != target) return -1;
        return l;
    }

    int higher(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        if (nums[l] != target) return -1;
        return l;
    }

    public static void main(String[] args) {

    }
}
