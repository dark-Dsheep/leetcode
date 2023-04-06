package Competition.biweekly.bw101;

import java.util.HashSet;

public class T1 {



    public int minNumber(int[] nums1, int[] nums2) {
        var set1 = new HashSet<Integer>();
        int m1 = 0x3f3f, m2 = 0x3f3f;
        for (var x : nums1) {
            set1.add(x);
            m1 = Math.min(m1, x);
        }
        for (int x : nums2) {
            if (set1.contains(x)) return x;
            m2 = Math.min(m2, x);
        }
        if (m1 < m2) {
            return m1 * 10 + m2;
        } else {
            return m2 * 10 + m1;
        }
    }

    public static void main(String[] args) {

    }
}
