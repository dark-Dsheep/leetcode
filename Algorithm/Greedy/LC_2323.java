package Algorithm.Greedy;

import java.util.Arrays;

public class LC_2323 {
    /*
    2323. 完成所有工作的最短时间 II
     */
    public int minimumTime(int[] jobs, int[] workers) {
        Arrays.sort(jobs);
        Arrays.sort(workers);
        int res = 0;
        int cnt = 0;
        for (int i = 0, j = 0; i < workers.length; i++, j++) {
            if (jobs[i] > workers[i]) {
                cnt = (int) Math.ceil(jobs[i] / (double) workers[i]);
            } else {
                cnt = 1;
            }
            res = Math.max(res, cnt);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] jobs = {3, 18, 15, 9};
        int[] workers = {6, 5, 1, 3};
        System.out.println(new LC_2323().minimumTime(jobs, workers));
    }

}
