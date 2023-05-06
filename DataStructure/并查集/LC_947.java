package DataStructure.并查集;

import java.util.HashMap;

public class LC_947 {

    /*
        947. 移除最多的同行或同列石头
     */
    public int removeStones(int[][] stones) {
        UnionFind u = new UnionFind(stones.length);
        for (int i = 0; i < stones.length; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                int x1 = stones[i][0];
                int y1 = stones[i][1];
                int x2 = stones[j][0];
                int y2 = stones[j][1];
                // 满足同一行 同一列的石头 进行合并
                if (x1 == x2 || y1 == y2) {
                    u.union(i, j);
                }
            }
        }
        return stones.length - u.getCount();

    }

    class UnionFind {
        int count;
        HashMap<Integer, Integer> parent;

        public UnionFind(int n) {
            this.count = n;
            this.parent = new HashMap<>(n);
        }

        public Integer find(Integer x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
            }
            while (!x.equals(parent.get(x))) {
                parent.put(x, parent.get(parent.get(x))); // 路径压缩
                x = parent.get(x);
            }
            return x;
        }

        public void union(int a, int b) {
            Integer aRoot = find(a);
            Integer bRoot = find(b);
            if (aRoot == null) aRoot = a;
            if (bRoot == null) bRoot = b;
            if (aRoot.equals(bRoot)) return;
            parent.put(bRoot, aRoot);
            count--;
        }

        public int getCount() {
            return count;
        }
    }


    public static void main(String[] args) {
        int[][] stones = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2,  1}, {2, 2}};
        System.out.println(new LC_947().removeStones(stones));
    }
}
