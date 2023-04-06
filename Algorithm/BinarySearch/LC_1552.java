package Algorithm.BinarySearch;

import java.util.Arrays;

public class LC_1552 {


    /*
        1552. 两球之间的磁力
     */
    public int maxDistance(int[] position, int m) {
        // 二分答案
        // 最小值最大 -> 模板2
        Arrays.sort(position);
        long l =  1;
        long r = Arrays.stream(position).max().getAsInt();

        while (l < r) {
            long mid = l + (r - l + 1) / 2;
            if (check(position, mid, m)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return (int) l;
    }

    private boolean check(int[] position, long mid, int m) {
        int cnt = 1;
        int pre = position[0];
        for (int i = 1; i < position.length; i++) {
            if (Math.abs(position[i] - pre) >= mid) {
                cnt++;
                pre = position[i];
            }
        }
        return cnt >= m;
    }

    public static void main(String[] args) {

    }
}
