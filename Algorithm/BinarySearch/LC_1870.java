package Algorithm.BinarySearch;

public class LC_1870 {

    /*
        1870. 准时到达的列车最小时速
     */
    int n = 0;
    public int minSpeedOnTime(int[] dist, double hour) {
        // 时间必须要大于路程段数减 1
        if (hour <= dist.length - 1) return -1;
        // 二分答案 -> 速度
        n = dist.length;
        long l = 1;
        long r = 10000000;
        while (l < r) {
            long mid = l + (r - l) / 2;
            // System.out.println("ans -> " + mid);
            if (check(dist, mid, hour)) {
                r = mid;
            } else {
                l = mid + 1; // 加快速度 -> 二分右边
            }
        }
        return (int) l;
    }

    // 判断速度为mid 能否在hour小时内到达
    private boolean check(int[] dist, long mid, double hour) {
        double cost = 0;
        for (int i = 0; i < n - 1; i++) {
            cost += (dist[i] + mid - 1) / mid;
//            cost +=  Math.ceil(dist[i] / (double) mid);
        }
        // 最后一次不用向上取整
        cost += dist[n - 1] / (double) mid;
        return hour - cost >= 0;
    }

    public static void main(String[] args) {

        int[] dist = {1, 3, 2};
        double hour = 2.7;
        System.out.println(new LC_1870().minSpeedOnTime(dist, hour));
    }
}
