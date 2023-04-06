package DataStructure.UnionFind;

import java.util.*;

public class LC_1202 {


    private Map<Character, Integer> map = new HashMap<>();
    private Set<Integer> vis = new HashSet<>();

    //TODO
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        var u = new UnionFind(s.length());
        for (var pair : pairs) {
            var a = pair.get(0);
            var b = pair.get(1);
            u.union(a, b, s.charAt(a), s.charAt(b));
        }
        var sb = new StringBuilder();
        for (var i = 0; i < s.length(); i++) {
            var r = u.find(i);
            if (!vis.contains(r)) {
                sb.append(s.charAt(r));
                vis.add(r);
            } else {
                sb.append(s.charAt(i));
                vis.add(i);
            }
        }
        return sb.toString();
    }


    class UnionFind {

        private int[] parent;

        public UnionFind(int n) {
            this.parent = new int[n];
            for (var i = 0; i < n; i++) {
                this.parent[i] = i;
            }
        }

        public int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int a, int b, int wa, int wb) {
            var aRoot = find(a);
            var bRoot = find(b);
            if (aRoot == bRoot) return;
            if (wa > wb) {
                parent[aRoot] = bRoot;
            } else {
                parent[bRoot] = aRoot;
            }
        }
    }


    public static void main(String[] args) {

    }
}
