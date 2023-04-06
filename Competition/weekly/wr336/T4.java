package Competition.weekly.wr336;

import java.util.Arrays;

public class T4 {


    public int findMinimumTime(int[][] tasks) {
        // 将区间按照右端点排序
        Arrays.sort(tasks, ((a, b) -> a[1] - b[1]));
        int ans = 0;
        var used = new boolean[2001];
        for (var t : tasks) {
            int st = t[0], ed = t[1], d = t[2];
            for (int i = st; i <= ed; i++) {
                if (used[i]) --d;           // 统计已经在运行中的时间点
            }
            for (int i = ed; d > 0; i--) { // 填充剩余的d的区间后缀
                if (!used[i]) {
                    used[i] = true;
                    --d;
                    ++ans;
                }
            }
        }
        return ans;
    }
    // 贪心 + 线段树
    public int findMinimumTime2(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> a[1] - b[1]);
        int u = tasks[tasks.length - 1][1];
        cnt = new int[u * 4];
        todo = new boolean[u * 4];
        for (var t : tasks) {
            int st = t[0], ed = t[1], d = t[2];
            suffix = d - query(1, 1, u, st, ed);
            if (suffix > 0) update(1, 1, u, st, ed);
        }
        return cnt[1];
    }

    int[] cnt;
    boolean[] todo;
    int suffix;

    void do_(int o, int l, int r) {
        cnt[o] = r - l + 1;
        todo[o] = true;
    }

    void spread(int o, int l, int m, int r) {
        if (todo[o]) {
            do_(o * 2, l, m);
            do_(o * 2 + 1, m + 1, r);
            todo[o] = false;
        }
    }

    int query(int o, int l, int r, int L, int R) {
        if (L <= l && r <= R) return cnt[o];
        int m = l + r >> 1;
        spread(o, l, m, r);
        if (m >= R) return query(o * 2, l, m, L, R);
        if (m < L) return query(o * 2 + 1, m + 1, r, L, R);
        return query(o * 2, l, m, L, R) + query(o * 2 + 1, m + 1, r, L, R);
    }

    void update(int o, int l, int r, int L, int R) {
        int size = r - l + 1;
        if (cnt[o] == size) return;
        if (L <= l && r <= R && size - cnt[o] <= suffix) {
            suffix -= size - cnt[o];
            do_(o, l, r);
            return;
        }
        int m = l + r >> 1;
        spread(o, l, m, r);
        if (m < R) update(o * 2 + 1, m + 1, r, L, R);
        if (suffix > 0) update(o * 2, l, m, L, R);
        cnt[o] = cnt[o * 2] + cnt[o * 2 + 1];
    }

    public static void main(String[] args) {
        int[][] t1 = {{2, 13, 2}, {6, 18, 5}, {2, 13, 3}};
        int[][] task = {{2, 3, 1}, {4, 5, 1}, {1, 5, 2}};
        int[][] task2 = {{1, 3, 2}, {2, 5, 3}, {5, 6, 2}};
        int[][] task3 = {{1, 3, 3}, {4, 5, 2}};
        System.out.println(new T4().findMinimumTime(t1));
    }
}
