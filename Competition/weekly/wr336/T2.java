package Competition.weekly.wr336;

import java.util.Arrays;

public class T2 {

    public int maxScore(int[] nums) {
        int n = nums.length;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }
        Arrays.sort(arr, ((o1, o2) -> o2 - o1));
        long s = arr[0];
        int ans = s > 0 ? 1 : 0;
        for (int i = 1; i < n; i++) {
            s += arr[i];
            if (s > 0) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
