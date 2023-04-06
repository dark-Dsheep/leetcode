package DataStructure.UnionFind;

import java.util.HashSet;

public class LC_1361 {

//1361. 验证二叉树
    public boolean validateBinaryTreeNodes(int n, int[] lc, int[] rc) {
        // 并查集解法
        // 1.这颗树不能有环 -> 并查集isConnented
        // 2.树只能是一颗   -> 联通分量 == 1
        // 3.是否只有一个根节点,通过set统计入度判断
        var u = new UnionFind(n);
        var set = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            if (lc[i] != -1) {
                if (u.isConnected(i, lc[i])) return false;
                u.union(i, lc[i]);
                set.add(lc[i]);
            }
            if (rc[i] != -1) {
                if (u.isConnected(i, rc[i])) return false;
                u.union(i, rc[i]);
                set.add(rc[i]);
            }
        }
        return u.getCnt() == 1 && set.size() == n - 1;
    }

    class UnionFind {
        int[] fa;
        int cnt;

        public UnionFind(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) fa[i] = i;
            cnt = n;
        }

        int find(int x) {
            while (x != fa[x]) {
                fa[x] = fa[fa[x]];
                x = fa[x];
            }
            return x;
        }

        boolean isConnected(int a, int b) {
            return find(a) == find(b);
        }

        void union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a == b) return;
            fa[b] = a;
            cnt--;
        }

        int getCnt() {
            return cnt;
        }
    }

    public static void main(String[] args) {

    }
}
