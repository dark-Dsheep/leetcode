package Competition.biweekly.bw101;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class T3 {

    int[] fa;

    int find(int x) {
        while (x != fa[x]) {
            fa[x] = fa[fa[x]];
            x = fa[x];
        }
        return x;
    }

    void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;
        fa[b] = a;
    }

    public long makeSubKSumEqual(int[] arr, int k) {
        int n = arr.length;
        fa = new int[n];
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
        for (int i = 0; i < n; i++) {
            int r = (i + k) % n;
            if (i != r) {
                union(i, r);
            }
        }
        var tmap = new TreeMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            int g = find(i);
            tmap.computeIfAbsent(g, v -> new ArrayList<>()).add(arr[i]);
        }
        // 中位数定理
        long ans = 0;
        for (var e : tmap.entrySet()) {
            List<Integer> list = e.getValue();
            Collections.sort(list);
            long mv = (long) list.get(list.size() / 2);
            ans += calc(mv, list);
        }
        return ans;
    }

    long calc(long v, List<Integer> list) {
        long ans = 0;
        for (int x : list) {
            ans += Math.abs(v - x);
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
