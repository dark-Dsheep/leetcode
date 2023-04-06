package Competition.biweekly.bw100;

public class T4 {


    public long repairCars(int[] ranks, int cars) {
        long l = 1;
        long r = 100000000000000L;
        while (l < r) {
            long mid = l + r >> 1;
            if (check(ranks, cars, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // r * r^2
    boolean check(int[] ranks, int cars, long mid) {
        for (long x : ranks) {
            cars -= (int) Math.sqrt(mid / x);
            if (cars <= 0) return true;
        }
        return cars <= 0;
    }



    public static void main(String[] args) {
        int[] ranks = {4, 2, 3, 1};
        int cars = 10;
        System.out.println(new T4().repairCars(ranks, cars));
    }
}
