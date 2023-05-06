package DataStructure.并查集;

public class LC_1061 {

    /*
        1061. 按字典序排列最小的等效字符串
     */
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        UnionFind u = new UnionFind();
        for (int i = 0; i < s1.length(); i++) {
            int a = s1.charAt(i) - 'a';
            int b = s2.charAt(i) - 'a';
            u.union(a, b);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            char ch = (char) ((char) u.find(c - 'a') + 'a');
            System.out.println(ch);
            sb.append(ch);
        }
        return sb.toString();
    }


    class UnionFind {
        int[] parent;

        public UnionFind() {
            this.parent = new int[26];
            for (int i = 0 ; i < 26; i++) {
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
            if (aRoot < bRoot) {        // 按照rank合并
                parent[bRoot] = aRoot;
            } else {
                parent[aRoot] = bRoot;
            }
        }
    }
    public static void main(String[] args) {

        String s1 = "parker";
        String s2 = "morris";
        String baseStr = "parser";
        System.out.println(new LC_1061().smallestEquivalentString(s1, s2, baseStr));
    }
}
