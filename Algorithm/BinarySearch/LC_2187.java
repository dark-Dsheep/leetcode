package Algorithm.BinarySearch;


public class LC_2187 {

    /*
        2187. 完成旅途的最少时间
     */
    public long minimumTime(int[] time, int totalTrips) {
        // 二分答案
        // 定义上下界
        long l = 1;
        long r = 100000000000000L;
        while (l < r) {
            long mid = l + (r - l) / 2;
            // System.out.println("mid => " + mid);
            if (check(time, mid, totalTrips)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    private boolean check(int[] time, long mid, long totalTrips) {
        // 时间为mid的时候能否完成totalTrips个旅途
        for (int t : time) {
            long f = mid / t;
            totalTrips -= f;
        }
        return totalTrips > 0;
    }


    public static void main(String[] args) {
        int[] time = {5, 10, 10};
        int totalTrips = 9;
        System.out.println(new LC_2187().minimumTime(time, totalTrips));
    }
}
