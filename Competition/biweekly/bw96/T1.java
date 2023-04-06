package Competition.biweekly.bw96;

import java.util.HashSet;

public class T1 {

    public int getCommon(int[] nums1, int[] nums2) {
        HashSet<Integer> set2 = new HashSet<>();
        for (int x : nums2) set2.add(x);

        for (int i = 0; i < nums1.length; i++) {
            if (set2.contains(nums1[i])) return nums1[i];
        }
        return -1;
    }



    public static void main(String[] args) {

    }
}
