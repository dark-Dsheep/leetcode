package DataStructure.HashMap;

import java.util.HashMap;

public class LC_2365 {


    public long taskSchedulerII(int[] tasks, int space) {
        long res = 0;
        var map = new HashMap<Integer, Long>();
        for (int i = 0; i < tasks.length; i++) {
            res += 1;       // 完成该任务 天数 + 1
            int t = tasks[i];
            if (map.containsKey(t)) {
                res = Math.max(res, map.get(t) + 1);
            }
            map.put(tasks[i], res + space); // 记录任务结束时间
        }
        return res;
    }

    public static void main(String[] args) {

        int[] tasks = {1, 2, 1, 2, 3, 1};
        int space = 3;
        System.out.println(new LC_2365().taskSchedulerII(tasks, space));
    }
}
