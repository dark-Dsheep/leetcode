package DataStructure.并查集;

import java.util.Arrays;
import java.util.Comparator;

public class LC_1101 {

    /*
        1101. 彼此熟识的最早时间
     */
    public int earliestAcq(int[][] logs, int n) {
        // 将时间戳从小到达排序
        Arrays.sort(logs, Comparator.comparing(o -> o[0]));
        UnionFind u = new UnionFind(n);
        for (int[] l : logs) {
            int timestamp = l[0];
            int a = l[1], b = l[2];
            u.union(a, b);
            if (u.getCount() == 1) return timestamp;
        }
        return -1;
    }

    class UnionFind {
        int count;
        int[] parent;

        public UnionFind(int n) {
            this.count = n;
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];  // 路径压缩
                x = parent[x];
            }
            return x;
        }

        public void union(int a, int b) {
            int aRoot = find(a);
            int bRoot = find(b);
            if (aRoot == bRoot) return;
            parent[aRoot] = bRoot;
            count--;
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        int[][] logs = {
                {20190101,0,1},
                {20190104,3,4},
                {20190107,2,3},
                {20190211,1,5},
                {20190224,2,4},
                {20190301,0,3},
                {20190312,1,2},
                {20190322,4,5}
        };
        int N = 6;
        System.out.println(new LC_1101().earliestAcq(logs, N));
    }
}
