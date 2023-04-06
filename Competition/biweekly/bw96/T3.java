package Competition.biweekly.bw96;

import java.util.Arrays;
import java.util.HashMap;

public class T3 {


    public long maxScore(int[] nums1, int[] nums2, int k) {
        long res = 0;
        int n = nums2.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums2[i], i);
        }
        Integer[] arr2 = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr2[i] = nums2[i];
        }
        Arrays.sort(arr2, ((o1, o2) -> o2 - o1));

        for (int i = 0; i < n; i++) {
            long minv = Integer.MAX_VALUE;
            long sum = 0;
            for (int j = i; j < k; j++) {
                minv = Math.min(minv, arr2[j]);
                sum += nums1[map.get(arr2[j])];
            }
            res = Math.max(res, sum * minv);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 3, 3, 2};
        int[] a2 =  {2, 1, 3, 4};
        int k = 3;
        System.out.println(new T3().maxScore(a1, a2, k));
    }
}
