package Competition.biweekly.bw96;

public class T2 {


    public long minOperations(int[] nums1, int[] nums2, int k) {
        // 记录需要减少的操作
        double decr = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] > nums2[i]) {
                decr += (nums1[i] - nums2[i]) / (double)k;
            }
        }
        // 记录需要增加的操作
        double incr = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] < nums2[i]) {
                incr += (nums2[i] - nums1[i]) / (double) k;
            }
        }
        if (incr == decr) {
            if (incr == 0) return 0;
            if (k == 0) return -1;
            if (incr > Math.floor(incr) && incr < Math.ceil(incr)) return -1;
            return (long) incr;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] a1 = {2, 5};
        int[] a2 = {5, 2};
        int k = 2;
        System.out.println(new T2().minOperations(a1, a2, k));
    }
}


