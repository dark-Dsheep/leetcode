package Competition.weekly.wr345;

import java.util.*;

public class T4 {


    class DSU {
        int count;
        int[] pa;

        public DSU(int n) {
            pa = new int[n];
            for (int i = 0; i < n; i++) {
                pa[i] = i;
            }
            count = n;
        }

        int find(int x) {
            while (x != pa[x]) {
                pa[x] = pa[pa[x]];
                x = pa[x];
            }
            return x;
        }

        void union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a == b) return;
            pa[b] = a;
            count--;
        }

        int getCount() {
            return count;
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        var gg = new HashMap<Integer, HashSet<Integer>>();
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            gg.computeIfAbsent(e[0], v -> new HashSet<>());
            gg.computeIfAbsent(e[1], v -> new HashSet<>());
            gg.get(e[0]).add(e[1]);
            gg.get(e[1]).add(e[0]);
            dsu.union(e[0], e[1]);
        }
        int ret = dsu.getCount();
        var groups = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            int pa = dsu.find(i);
            groups.computeIfAbsent(pa, v -> new ArrayList<>());
            groups.get(pa).add(i);
        }
        for (var group : groups.values()) {
            for (int i = 0; i < group.size(); i++) {
                boolean ok = true;
                for (int j = i+1; j < group.size(); j++) {
                    if (!gg.get(group.get(i)).contains(group.get(j))) {
                        ok = false;
                        break;
                    }
                }
                if (!ok) {
                    ret--;
                    break;
                }
            }
        }
        return Math.max(ret, 0);
    }


    public static void main(String[] args) {

    }
}
