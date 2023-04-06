package Competition.weekly.wr332;


import java.util.Arrays;

public class T2 {

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int x1 = lower - nums[i];
            int x2 = upper - nums[i];
            int l1 = findL(nums, x1, i + 1, nums.length - 1);
            int l2 = findR(nums, x2, i + 1, nums.length - 1);
            if (l1 == -1 || l2 == -1) continue;
            ans += l2 - l1 + 1;
        }
        return ans;
    }

    int findL(int[] nums, int x, int l, int r) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (l > nums.length - 1 || nums[l] < x) return -1;
        return l;
    }

    int findR(int[] nums, int x, int l, int r) {
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (nums[mid] <= x) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        if (l > nums.length - 1 || nums[l] > x) return -1;
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 7, 4, 4, 5};
        int lower = 3;
        int upper = 6;
        System.out.println(new T2().countFairPairs(nums, lower, upper));
    }
}
