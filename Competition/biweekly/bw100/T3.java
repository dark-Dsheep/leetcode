package Competition.biweekly.bw100;

import java.util.HashSet;
import java.util.PriorityQueue;

public class T3 {

    HashSet<Integer> vis = new HashSet<>();

    public long findScore(int[] nums) {
        long ret = 0;
        var pq = new PriorityQueue<Info>(((o1, o2) -> {
            if (o1.val == o2.val) return o1.index - o2.index;
            return Math.toIntExact(o1.val - o2.val);
        }));
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || i == nums.length - 1) {
                pq.offer(new Info(i, nums[i], 1));
            } else {
                pq.offer(new Info(i, nums[i], 2));
            }
        }
        while (pq.size() > 0) {
            var p = pq.poll();
            if (vis.contains(p.index)) continue;
            ret += p.val;
            int idx = p.index;
            vis.add(idx);
            if (p.cnt == 1) {
                if (p.index == 0) vis.add(idx + 1);
                else            vis.add(idx - 1);
            }
            else { vis.add(idx - 1); vis.add(idx + 1);}
        }
        return ret;
    }

    public long findScore2(int[] nums) {
        long ans = 0;
        var mk = new boolean[100001];
        var pq = new PriorityQueue<int[]>((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        while (pq.size() > 0) {
            var p = pq.poll();
            if (mk[p[1]]) continue;
            mk[p[1]] = true;
            ans += p[0];
            if (p[1] - 1 >= 0) mk[p[1] - 1] = true;
            if (p[1] + 1 < nums.length) mk[p[1] + 1] = true;
        }
        return ans;
    }

    class Info {
        int index;
        long val;
        int cnt;

        public Info(int index, long val, int cnt) {
            this.index = index;
            this.val = val;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {

        int[] nums = {2,3,5,1,3,2};
        System.out.println(new T3().findScore(nums));
    }
}
