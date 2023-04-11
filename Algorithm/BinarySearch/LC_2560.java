package Algorithm.BinarySearch;

public class LC_2560 {


//    2560. 打家劫舍 IV

    public int minCapability(int[] nums, int k) {
        int l = 1;
        int r = 1000000000;
        while (l < r) {
            int mid = l + r >> 1;
            if (check(nums, k, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // check最小答案为mid的时候, 小偷能否偷到至少k间满足小于等于mid。
    boolean check(int[] nums, int k, int mid) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= mid) {
                cnt++;
                i++;    // 跳过下一个
            }
        }
        return cnt >= k;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 5, 9};
        int k = 2;
        System.out.println(new LC_2560().minCapability(a, k));
    }
}
