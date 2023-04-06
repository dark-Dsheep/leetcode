package Algorithm.BinarySearch;

import java.util.Arrays;

public class LC_2383 {

//    2383. 赢得比赛需要的最少训练时长
    public int minNumberOfHours(int initEnergy, int initExp, int[] ene, int[] exp) {
        int l = 1;
        int r = Arrays.stream(exp).max().getAsInt() + 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (check(exp, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        int sumEnergy = Arrays.stream(ene).sum();
        // +1 是能量要严格大于总和
        return Math.max(0, sumEnergy + 1 - initEnergy) + Math.max(0, l - initExp);
    }

    // check经验为mid 能否过关
    boolean check(int[] exp, int mid) {
        int cnt = mid;
        for (int x : exp) {
            if (cnt <= x) return false;
            cnt += x;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
