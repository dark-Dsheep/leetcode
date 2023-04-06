package Algorithm.BinarySearch;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;

public class LC_826 {

//    826. 安排工作以达到最大收益

//    排序 + 二分
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            int d = difficulty[i];
            if (map.containsKey(d)) {
                map.put(d, Math.max(map.get(d), profit[i]));
            } else {
                map.put(d, profit[i]);
            }
        }
        Arrays.sort(difficulty);
        for (int i = 1; i < n; i++) {
            int d1 = difficulty[i];
            int d0 = difficulty[i - 1];
            if (map.get(d0) > map.get(d1)) {
                map.put(d1, map.get(d0));
            }
        }
        int ans = 0;
        for (int x : worker) {
            int l = 0, r = n - 1;
            // 二分小于等于x的最大值
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (difficulty[mid] <= x) l = mid;
                else                      r = mid - 1;
            }
            ans += difficulty[l] > x ? 0 : map.get(difficulty[l]);
        }
        return ans;
    }

//    排序 + 双指针
    public int maxProfitAssignment1(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        Point[] jobs = new Point[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Point(difficulty[i], profit[i]);
        }
        Arrays.sort(jobs, ((o1, o2) -> o1.x - o2.x));
        Arrays.sort(worker);

        int ans = 0, i = 0, best = 0;
        for (var skill : worker) {
            while (i < n && skill >= jobs[i].x) {
                best = Math.max(best, jobs[i++].y);
            }
            ans += best;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] diff = {66,1,28,73,53,35,45,60,100,44,59,94,27,88,7,18,83,18,72,63};
        int[] pro = {66,20,84,81,56,40,37,82,53,45,43,96,67,27,12,54,98,19,47,77};
        int[] worker = {61,33,68,38,63,45,1,10,53,23,66,70,14,51,94,18,28,78,100,16};

        System.out.println(new LC_826().maxProfitAssignment(diff, pro, worker));
    }
}
