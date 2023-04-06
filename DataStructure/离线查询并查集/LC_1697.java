package DataStructure.离线查询并查集;

import java.util.Arrays;

public class LC_1697 {

    int[] fa;

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        var index = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> queries[a][2] - queries[b][2]);
        fa = new int[n];
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
        var ans = new boolean[queries.length];
        int i = 0;
        for (int query : index) {
            while (i < edgeList.length && edgeList[i][2] < queries[query][2]) {
                union(edgeList[i][0], edgeList[i][1]);
                i++;
            }
            ans[query] = connected(queries[query][0], queries[query][1]);
        }
        return ans;
    }

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

    boolean connected(int a, int b) {
        return find(a) == find(b);
    }

    public static void main(String[] args) {

    }


}
