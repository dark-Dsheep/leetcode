package DataStructure.并查集;


public class LC_2492 {

    /*
        2492. 两个城市间路径的最小分数
     */
    public int minScore(int n, int[][] roads) {
        int res = Integer.MAX_VALUE;
        UnionFind u = new UnionFind(n);
        for (int[] road : roads) {
            u.union(road[0], road[1]); //将边连通
        }
        for (int[] road : roads) {
            // 找跟1连通的最小距离
            if (u.isConnected(1, road[0])) {
                res = Math.min(res, road[2]);
            }
        }
        return res;
    }

    class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            this.parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while(parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int a, int b) {
            int aRoot = find(a);
            int bRoot = find(b);
            if (aRoot == bRoot) return;
            parent[bRoot] = aRoot;
        }

        boolean isConnected(int a, int b) {
            return find(a) == find(b);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] roads = {
                {1, 2, 9},
                {2, 3, 6},
                {2, 4, 5},
                {1, 4, 7}
        };
        System.out.println(new LC_2492().minScore(n, roads));
    }
}
