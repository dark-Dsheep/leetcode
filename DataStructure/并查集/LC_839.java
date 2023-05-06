package DataStructure.并查集;

public class LC_839 {

    /*
    839. 相似字符串组
     */
    public int numSimilarGroups(String[] strs) {
        UnionFind u = new UnionFind(strs.length);
        for (int i = 0; i < strs.length; i++) {
            String a = strs[i];
            for (int j = i + 1; j < strs.length; j++) {
                String b = strs[j];
                if (check(a, b) && !u.isConnected(i, j)) {
                    u.union(i, j);
                }
            }
        }
        return u.getCount();
    }

    private boolean check(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff += 1;
            }
        }
        return diff <= 2; // 相似字符只允许出现两个位置出现不同字符
    }

    class UnionFind {
        private int[] parent;
        private int count;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.count = n;
            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
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
            count--;
        }

        public boolean isConnected(int a, int b) {
            return find(a) == find(b);
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        String[] strs = {"tars", "rats", "arts", "star"};
        System.out.println(new LC_839().numSimilarGroups(strs));
    }
}
