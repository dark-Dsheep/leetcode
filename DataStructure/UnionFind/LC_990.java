package DataStructure.UnionFind;

public class LC_990 {

    int[] parent = new int[26];
    /*
        990. 等式方程的可满足性
     */

    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        // 先处理等式
        for (String e : equations) {
            int node1 = e.charAt(0) - 'a';
            int node2 = e.charAt(3) - 'a';
            char exp = e.charAt(1);
            if (exp == '=') union(node1, node2);
        }
        // 处理不等式
        for (String e : equations) {
            int node1 = e.charAt(0) - 'a';
            int node2 = e.charAt(3) - 'a';
            char exp = e.charAt(1);
            if (exp == '!') { // 不等式 -> 判断节点是否相连
                if (isConnected(node1, node2)) return false;
            }
        }
        return true;
    }

    int find(int x) {
        while (parent[x] != x) {
            x = parent[parent[x]];
        }
        return x;
    }

    void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot) return;
        parent[yRoot] = xRoot;
    }

    boolean isConnected(int a, int b) {
        return find(a) == find(b);
    }

    public static void main(String[] args) {
        String[] equations = {"a==b", "b!=c", "c==a"};
        System.out.println(new LC_990().equationsPossible(equations));
    }
}
